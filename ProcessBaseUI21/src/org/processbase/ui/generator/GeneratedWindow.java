/**
 * Copyright (C) 2010 PROCESSBASE Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.processbase.ui.generator;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ow2.bonita.facade.def.majorElement.DataFieldDefinition;
import org.ow2.bonita.facade.runtime.TaskInstance;
import org.processbase.bpm.BPMModule;
import org.processbase.bpm.forms.XMLFormDefinition;
import org.processbase.bpm.forms.XMLWidgetsDefinition;

/**
 *
 * @author marat
 */
public class GeneratedWindow extends Window implements Button.ClickListener {

    protected HashMap<Component, XMLWidgetsDefinition> components = new HashMap<Component, XMLWidgetsDefinition>();
    protected HashMap<String, Object> procVariables = new HashMap<String, Object>();
    protected ArrayList<XMLFormDefinition> forms;
    protected TaskInstance task;
    protected ArrayList<GridLayout> pages = new ArrayList<GridLayout>();
    protected BPMModule bpmModule = null;

    public GeneratedWindow(String caption) {
        super(caption);
    }

    protected void prepareWindow() {
        VerticalLayout layout = (VerticalLayout) getContent();
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setStyleName(Reindeer.LAYOUT_WHITE);
        layout.setSizeUndefined();
//        genWindow.setModal(true);
        for (XMLFormDefinition form : forms) {
            GridLayout page = new GridLayout(form.getnColumn(), form.getnLine());
            page.setMargin(true);
            page.setSpacing(true);
            page.setSizeUndefined();
            System.out.println("GRID " + form.getnColumn() + " " + form.getnLine());
            page.setHeight(form.getHeight() != null ? (form.getHeight().contains("%") ? form.getHeight() : form.getHeight() + "px") : "100%");
            page.setWidth(form.getWidth() != null ? (form.getWidth().contains("%") ? form.getWidth() : form.getWidth() + "px") : "100%");
            pages.add(page);

            ArrayList<XMLWidgetsDefinition> widgetsList = form.getWidgets();
            for (XMLWidgetsDefinition widgets : widgetsList) {
                System.out.println("ADD TO GRID " + widgets.getColumn() + " " + widgets.getLine() + " " + (widgets.getColumn() + (widgets.getHorizontalSpan() > 0 ? widgets.getHorizontalSpan() : 0)));
                Component component = getComponent(widgets);
                if (component != null) {
                    components.put(component, widgets);
                    page.addComponent(component, widgets.getColumn(), widgets.getLine(), widgets.getColumn() + (widgets.getHorizontalSpan() > 0 ? widgets.getHorizontalSpan() - 1 : 0), widgets.getLine());
                }
            }

        }
        addComponent(pages.get(0));
        center();
        setModal(true);



//        genWindow.setSizeUndefined();
//        genWindow.setResizable(false);
    }

    private Component getComponent(XMLWidgetsDefinition widgets) {
        Component result = null;
        Object value = null;
        DataFieldDefinition dfd = null;
        try {
            if (widgets.getSetVarScript() != null) {
                value = bpmModule.getProcessInstanceVariable(task.getProcessInstanceUUID(), widgets.getSetVarScript());
                dfd = bpmModule.getProcessDataField(task.getProcessDefinitionUUID(), widgets.getSetVarScript());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (widgets.getType().equals("form:TextFormField")) {
            TextField component = new TextField(widgets.getDisplayLabel());
            component.setValue(value);
            component.setNullRepresentation("");
            result = component;
        }
        if (widgets.getType().equals("form:TextAreaFormField")) {
            TextField component = new TextField(widgets.getDisplayLabel());
            component.setValue(value);
            component.setRows(4);
            component.setNullRepresentation("");
            result = component;
        }
        if (widgets.getType().equals("form:RichTextAreaFormField")) {
            RichTextArea component = new RichTextArea(widgets.getDisplayLabel());
            component.setValue(value);
            component.setNullRepresentation("");
            result = component;
        }
        if (widgets.getType().equals("form:SelectFormField")) {
            NativeSelect component = new NativeSelect(widgets.getDisplayLabel());
            for (String key : dfd.getEnumerationValues()) {
                component.addItem(key);
            }
            component.setValue(value);
            result = component;
        }
        if (widgets.getType().equals("form:SubmitFormButton")) {
            Button component = new Button(widgets.getDisplayLabel());
            component.addListener((Button.ClickListener) this);
            result = component;
        }
        return result;
    }

    public void buttonClick(ClickEvent event) {
        Button btn = event.getButton();
        if (getWidgets(btn).getType().equals("form:SubmitFormButton")) {
            try {
                setProcessVariables();
                bpmModule.finishTask(task, true, procVariables);
                close();
            } catch (Exception ex) {
                this.showNotification("Error", ex.getMessage().substring(250), Notification.TYPE_WARNING_MESSAGE);
            }
        }
    }

    private void setProcessVariables() throws Exception {
        for (Component comp : components.keySet()) {
            XMLWidgetsDefinition widgets = components.get(comp);
            if (widgets.getType().equals("form:TextFormField")) {
                procVariables.put(widgets.getSetVarScript(), ((TextField) comp).getValue());
            }
            if (widgets.getType().equals("form:TextAreaFormField")) {
                procVariables.put(widgets.getSetVarScript(), ((TextField) comp).getValue());
            }
            if (widgets.getType().equals("form:RichTextAreaFormField")) {
                procVariables.put(widgets.getSetVarScript(), ((RichTextArea) comp).getValue());
            }
            if (widgets.getType().equals("form:SelectFormField")) {
                procVariables.put(widgets.getSetVarScript(), ((NativeSelect) comp).getValue());
            }
        }
    }

    private XMLWidgetsDefinition getWidgets(Component c) {
        for (Component comp : components.keySet()) {
            if (comp.equals(c)) {
                return components.get(comp);
            }
        }
        return null;
    }
}
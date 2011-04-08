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
package org.processbase.ui.bam.admin;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import java.util.Iterator;
import org.processbase.ui.core.Processbase;
import org.processbase.ui.core.template.ButtonBar;
import org.processbase.ui.core.template.PbWindow;
import org.processbase.util.bam.metadata.HibernateUtil;
import org.processbase.util.bam.metadata.MetaDim;

/**
 *
 * @author mgubaidullin
 */
public class DimentionWindow extends PbWindow
        implements ClickListener, ValueChangeListener {

    private MetaDim metaDim = null;
    private ButtonBar buttons = new ButtonBar();
    private Button closeBtn;
    private Button saveBtn;
    private TextField code;
    private TextField name;
    private NativeSelect valueType;
    private TextField length;

    public DimentionWindow(MetaDim metaDim) {
        super();
        this.metaDim = metaDim;
    }

    public void initUI() {
        try {
            if (metaDim == null) {
                setCaption(((Processbase) getApplication()).getMessages().getString("newDimension"));
            } else {
                setCaption(((Processbase) getApplication()).getMessages().getString("dimension") + metaDim.getCode());
            }
            setModal(true);
            VerticalLayout layout = (VerticalLayout) this.getContent();
            layout.setMargin(true);
            layout.setSpacing(true);
            layout.setStyleName(Reindeer.LAYOUT_WHITE);

            closeBtn = new Button(((Processbase) getApplication()).getMessages().getString("btnClose"), this);
            saveBtn = new Button(((Processbase) getApplication()).getMessages().getString("btnSave"), this);
            code = new TextField(((Processbase) getApplication()).getMessages().getString("code"));
            name = new TextField(((Processbase) getApplication()).getMessages().getString("name"));
            valueType = new NativeSelect(((Processbase) getApplication()).getMessages().getString("valueType"));
            length = new TextField(((Processbase) getApplication()).getMessages().getString("length"));

            code.setWidth("270px");
            code.setMaxLength(20);
            code.setRequired(true);
            code.addValidator(new RegexpValidator("^[A-Z]\\w{1,15}$", ((Processbase) getApplication()).getMessages().getString("codeValidatorError")));
            addComponent(code);
            name.setWidth("270px");
            name.setMaxLength(500);
            name.setRequired(true);
            addComponent(name);
            valueType.addItem("int");
            valueType.addItem("java.lang.String");
            valueType.addItem("long");
            valueType.setWidth("265px");
            valueType.setNullSelectionAllowed(false);
            valueType.setRequired(true);
            valueType.addListener(this);
            valueType.setImmediate(true);
            addComponent(valueType);
            length.setWidth("270px");
            length.setMaxLength(4);
            length.setEnabled(false);
            length.setRequired(false);
            addComponent(length);

            if (metaDim != null) {
                code.setValue(metaDim.getCode());
                name.setValue(metaDim.getName());
                valueType.setValue(metaDim.getValueType());
                length.setValue(metaDim.getValueLength());
            } else {
                HibernateUtil hutil = new HibernateUtil();
                code.setValue("D" + String.format("%05d", new Integer(hutil.getAllMetaDim().size() + 1)));
            }

            buttons.addButton(saveBtn);
            buttons.setComponentAlignment(saveBtn, Alignment.MIDDLE_RIGHT);
            buttons.setExpandRatio(saveBtn, 1);
            buttons.addButton(closeBtn);
            buttons.setComponentAlignment(closeBtn, Alignment.MIDDLE_RIGHT);
            buttons.setMargin(false);
            buttons.setHeight("30px");
            buttons.setWidth("100%");
            addComponent(buttons);
            setWidth("310px");
            setResizable(false);
        } catch (Exception ex) {
            ex.printStackTrace();
            showError(ex.getMessage());
        }
    }

    public void buttonClick(ClickEvent event) {
        try {
            if (event.getButton().equals(saveBtn)) {
                commit();
                metaDim = new MetaDim();
                metaDim.setCode(code.getValue().toString());
                metaDim.setName(name.getValue().toString());
                metaDim.setValueType(valueType.getValue().toString());
                if (length.getValue() != null && !length.getValue().toString().isEmpty()) {
                    metaDim.setValueLength(Short.parseShort(length.getValue().toString()));
                }
                HibernateUtil hutil = new HibernateUtil();
                if (hutil.getMetaDimByCode(metaDim.getCode()).isEmpty()) {
                    hutil.addMetaDim(metaDim);
                } else {
                    throw new Exception(((Processbase) getApplication()).getMessages().getString("uniqueDimCode"));
                }
                close();
            } else if (event.getButton().equals(closeBtn)) {
                close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showError(ex.getMessage());
        }
    }

    private void commit() {
        for (Iterator<Component> iter = getComponentIterator(); iter.hasNext();) {
            Component c = iter.next();
            if (c instanceof AbstractField) {
                ((AbstractField) c).validate();
            }
        }
    }

    public void valueChange(ValueChangeEvent event) {
        if (event.getProperty().getValue().equals("java.lang.String")) {
            length.setEnabled(true);
            length.setRequired(true);
        } else {
            length.setRequired(false);
            length.setEnabled(false);
        }
    }
}
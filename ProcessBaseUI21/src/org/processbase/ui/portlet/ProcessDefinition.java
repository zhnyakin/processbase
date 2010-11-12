/**
 * Copyright (C) 2010 PROCESSBASE
 * PROCESSBASE Ltd, Almaty, Kazakhstan
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
package org.processbase.ui.portlet;

import com.vaadin.ui.Layout;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.processbase.ui.admin.ProcessDefinitionsPanel;
import org.processbase.ui.template.PbWindow;

/**
 *
 * @author mgubaidullin
 */
public class ProcessDefinition extends InternalApplication {

    private PbWindow processDefinitionWindow;
    private ProcessDefinitionsPanel processDefinitionsPanel;

    @Override
    public void init() {
        super.init();
        processDefinitionWindow = new PbWindow(this.getPortletApplicationContext2());
        ((Layout) processDefinitionWindow.getContent()).setMargin(false);
        processDefinitionWindow.setSizeFull();
        this.setMainWindow(processDefinitionWindow);
    }

    @Override
    public void createApplication(RenderRequest request, RenderResponse response) {
        processDefinitionsPanel = new ProcessDefinitionsPanel(getPortletApplicationContext2());
        processDefinitionsPanel.refreshTable();
        processDefinitionWindow.addComponent(processDefinitionsPanel);

    }
}

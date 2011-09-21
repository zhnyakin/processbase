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
package org.processbase.ui.bpm.panel;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

import org.ow2.bonita.facade.identity.Membership;
import org.ow2.bonita.facade.identity.ProfileMetadata;
import org.ow2.bonita.facade.identity.User;
import org.processbase.ui.bpm.worklist.NewProcesses;
import org.processbase.ui.bpm.worklist.Processes;
import org.processbase.ui.bpm.worklist.TaskCompleted;
import org.processbase.ui.bpm.worklist.TaskList;
import org.processbase.ui.core.BPMModule;
import org.processbase.ui.core.ProcessbaseApplication;
import org.processbase.ui.core.template.ButtonBar;
import org.processbase.ui.core.template.TablePanel;
import org.processbase.ui.core.template.TreeTablePanel;
import org.processbase.ui.core.template.WorkPanel;
import org.processbase.ui.osgi.PbPanelModule;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.Reindeer;

/**
 *
 * @author mgubaidullin
 */
public class TaskListPanel extends PbPanelModule implements Button.ClickListener {

    private ButtonBar buttonBar = new ButtonBar();
    private TaskList taskListPanel;
    private TaskCompleted taskCompletedPanel;
    private Processes processesPanel;
    private NewProcesses newProcessesPanel;
    private Button refreshBtn = null;
    private Button myTaskListBtn = null;
    private Button myTaskCompletedBtn = null;
    private Button myProcessesBtn = null;
    private Button myNewProcessesBtn = null;
    private HashMap<Button, WorkPanel> panels = new HashMap<Button, WorkPanel>();
	private com.vaadin.ui.ComboBox roleCombo;

    public void initUI(){
        panels.clear();
        removeAllComponents();
        setMargin(false);    
  
       
        

       
       // myTaskListBtn.setCaption(ProcessbaseApplication.getString("myTaskListBtn") + " (" + taskListPanel.rowCount + ")");
        newProcessesPanel = new NewProcesses();
        if(ProcessbaseApplication.getCurrent().getUserName()==BPMModule.USER_GUEST)
        {
        	addComponent(newProcessesPanel, 0);
        	setExpandRatio(newProcessesPanel, 1);
        	newProcessesPanel.initUI();
        	newProcessesPanel.refreshTable();        	
        	return;
        }
        
       
        
        addComponent(buttonBar);
        
        taskListPanel = new TaskList();
        prepareButtonBar();
        panels.put(myTaskListBtn, taskListPanel);
        addComponent(taskListPanel, 1);
        setExpandRatio(taskListPanel, 1);
        taskListPanel.initUI();
        taskListPanel.refreshTable();
        
        
        
        User user=ProcessbaseApplication.getCurrent().getCurrentUser();
        roleCombo = new com.vaadin.ui.ComboBox();
        roleCombo.setInputPrompt("Select group");
        roleCombo.setNullSelectionAllowed(false);
        roleCombo.setInvalidAllowed(false);
        roleCombo.removeAllItems();
        if(user!=null && user.getMemberships()!=null){
        	for (Membership membership : user.getMemberships()) {
        		roleCombo.addItem(membership.getGroup().getLabel());
			}
        }
        if(roleCombo.size()>0)
        {
        	
        	ProfileMetadata currentProfileMetadata=null;
			for (ProfileMetadata profileMetadata : user.getMetadata().keySet()) {
	            if (profileMetadata.getName().equals("CURRENT_GROUP")) {
	            	currentProfileMetadata=profileMetadata;
	            	break;
	            }
	        }
			if(currentProfileMetadata!=null)
			{
				String mt= user.getMetadata().get(currentProfileMetadata.getName());
				String userMetadataValue = ProcessbaseApplication.getCurrent().getBpmModule().getUserMetadataValue(user, currentProfileMetadata.getName());
				roleCombo.select(userMetadataValue);
			}
			
        	
        }
        
        buttonBar.addComponent(roleCombo);
    	roleCombo.setImmediate(true);
    	roleCombo.addListener(new com.vaadin.data.Property.ValueChangeListener() {
			
			public void valueChange(ValueChangeEvent event) {
				Property property = event.getProperty();
				getWindow().showNotification("Selected role:"+property);	
				
				try {
					User currentUser = ProcessbaseApplication.getCurrent().getCurrentUser();
					ProcessbaseApplication.getCurrent().getBpmModule().updateUserMetadata(currentUser, "CURRENT_GROUP", property.toString());
					for (Membership membership : currentUser.getMemberships()) {
		        		if(membership.getGroup().getLabel().equals(property.toString()))
		        			{
		        				newProcessesPanel.setUserCurrentGroup(membership.getGroup());
		        				return;
		        			}
					}
					
				} catch (Exception e) {
					
					throw new RuntimeException("Error on updating user metadata",e );
				}
			}
		});
        roleCombo.setVisible(false);
        taskCompletedPanel = new TaskCompleted();
        panels.put(myTaskCompletedBtn, taskCompletedPanel);

        processesPanel = new Processes();
        panels.put(myProcessesBtn, processesPanel);
        panels.put(myNewProcessesBtn, newProcessesPanel);
        //setCurrentPanel(taskListPanel);
    }

    private void setCurrentPanel(WorkPanel workPanel) {
        replaceComponent(getComponent(1), workPanel);
        setExpandRatio(workPanel, 1);
        if (!workPanel.isInitialized()){
                workPanel.initUI();
            }
        if (workPanel instanceof TablePanel){
            ((TablePanel)workPanel).refreshTable();
        } else if (workPanel instanceof TreeTablePanel){
            ((TreeTablePanel)workPanel).refreshTable();
        }
        //workPanel.initUI();
    }

    private void prepareButtonBar() {
        buttonBar.removeAllComponents();
        // prepare myNewProcessesBtn button
        myNewProcessesBtn = new Button(ProcessbaseApplication.getString("myNewProcessesBtn"), this);
        myNewProcessesBtn.setStyleName(Reindeer.BUTTON_LINK);
        buttonBar.addComponent(myNewProcessesBtn, 0);
        buttonBar.setComponentAlignment(myNewProcessesBtn, Alignment.MIDDLE_LEFT);

        // prepare myTaskListBtn button
        myTaskListBtn = new Button(ProcessbaseApplication.getString("myTaskListBtn"), this);
        myTaskListBtn.setStyleName("special");
        myTaskListBtn.setEnabled(false);
        buttonBar.addComponent(myTaskListBtn, 1);
        buttonBar.setComponentAlignment(myTaskListBtn, Alignment.MIDDLE_LEFT);

        // prepare myProcessesBtn button
        myProcessesBtn = new Button(ProcessbaseApplication.getString("myProcessesBtn"), this);
        myProcessesBtn.setStyleName(Reindeer.BUTTON_LINK);
        buttonBar.addComponent(myProcessesBtn, 2);
        buttonBar.setComponentAlignment(myProcessesBtn, Alignment.MIDDLE_LEFT);

        // prepare myTaskCompletedBtn button
        myTaskCompletedBtn = new Button(ProcessbaseApplication.getString("myTaskCompletedBtn"), this);
        myTaskCompletedBtn.setStyleName(Reindeer.BUTTON_LINK);
        buttonBar.addComponent(myTaskCompletedBtn, 3);
        buttonBar.setComponentAlignment(myTaskCompletedBtn, Alignment.MIDDLE_LEFT);

        // prepare help button
        refreshBtn = new Button(ProcessbaseApplication.getString("btnRefresh"), this);
        buttonBar.addComponent(refreshBtn, 4);
        buttonBar.setComponentAlignment(refreshBtn, Alignment.MIDDLE_RIGHT);
        buttonBar.setExpandRatio(refreshBtn, 1);
        buttonBar.setWidth("100%");
    }

    public void buttonClick(ClickEvent event) {
        WorkPanel panel = panels.get(event.getButton());
        if (event.getButton().equals(refreshBtn) && (getComponent(1) instanceof TablePanel)) {
            ((TablePanel) getComponent(1)).refreshTable();
        } else if (event.getButton().equals(refreshBtn) && (getComponent(1) instanceof TreeTablePanel)) {
            ((TreeTablePanel) getComponent(1)).refreshTable();
        } else {
            activateButtons();
            event.getButton().setStyleName("special");
            event.getButton().setEnabled(false);
            setCurrentPanel(panel);
        }
        roleCombo.setVisible(false);
        if (!myTaskListBtn.isEnabled()) {
            myTaskListBtn.setCaption(ProcessbaseApplication.getString("myTaskListBtn") + " (" + taskListPanel.rowCount + ")");
        } else if (!myProcessesBtn.isEnabled()) {
            myProcessesBtn.setCaption(ProcessbaseApplication.getString("myProcessesBtn") + " (" + processesPanel.rowCount + ")");
        } else if (!myTaskCompletedBtn.isEnabled()) {
            myTaskCompletedBtn.setCaption(ProcessbaseApplication.getString("myTaskCompletedBtn") + " (" + taskCompletedPanel.rowCount + ")");
        } else if (!myNewProcessesBtn.isEnabled()) {
        	roleCombo.setVisible(roleCombo.size()>0);
            myNewProcessesBtn.setCaption(ProcessbaseApplication.getString("myNewProcessesBtn"));
        }
    }

    private void activateButtons() {
        myProcessesBtn.setStyleName(Reindeer.BUTTON_LINK);
        myProcessesBtn.setEnabled(true);
        myProcessesBtn.setCaption(ProcessbaseApplication.getString("myProcessesBtn"));

        myTaskListBtn.setStyleName(Reindeer.BUTTON_LINK);
        myTaskListBtn.setEnabled(true);
        myTaskListBtn.setCaption(ProcessbaseApplication.getString("myTaskListBtn"));

        myTaskCompletedBtn.setStyleName(Reindeer.BUTTON_LINK);
        myTaskCompletedBtn.setEnabled(true);
        myTaskCompletedBtn.setCaption(ProcessbaseApplication.getString("myTaskCompletedBtn"));

        myNewProcessesBtn.setStyleName(Reindeer.BUTTON_LINK);
        myNewProcessesBtn.setEnabled(true);
        myNewProcessesBtn.setCaption(ProcessbaseApplication.getString("myNewProcessesBtn"));
    }

    @Override
    public String getTitle(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        return rb.getString("bpmTasklist");
    }
}

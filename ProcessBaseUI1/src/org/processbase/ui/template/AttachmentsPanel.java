/**
 * Copyright (C) 2009  Marat Gubaidullin.
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation
 * version 2.1 of the License.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 **/
package org.processbase.ui.template;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.terminal.StreamResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.processbase.util.Constants;
import org.processbase.util.db.HibernateUtil;
import org.processbase.util.db.PbAttachment;

/**
 *
 * @author mgubaidullin
 */
public class AttachmentsPanel extends TablePanel
        implements Button.ClickListener, Upload.SucceededListener, Upload.FailedListener, Upload.Receiver {

    private HibernateUtil hutil = new HibernateUtil();
    private String processUUID = null;
    private Upload upload = new Upload("", this);
    private File file;
    private String MIMEType;
    private String filename;
    private Container fileTypesContainer = null;
    private ArrayList<PbAttachment> toDelete = new ArrayList<PbAttachment>();
    private boolean readonly = false;

    public AttachmentsPanel(String processUUID, Container fileTypesContainer, boolean readonly) {
        super();
        this.processUUID = processUUID;
        this.fileTypesContainer = fileTypesContainer;
        this.readonly = readonly;
        upload.setButtonCaption(messages.getString("btnUpload"));
        upload.addListener((Upload.SucceededListener) this);
        upload.addListener((Upload.FailedListener) this);
        upload.setImmediate(true);
        if (readonly) {
            this.removeComponent(buttonBar);
        } else {
            buttonBar.removeButton(refreshBtn);
            buttonBar.addComponent(upload);
        }
        initTableUI();
    }

    @Override
    public void initTableUI() {
        super.initTableUI();
        if (readonly) {
            table.addContainerProperty("id", String.class, null, "id", null, null);
            table.setColumnWidth("id", 30);
            table.addContainerProperty("type", String.class, null, messages.getString("tableCaptionSection"), null, null);
            table.setColumnWidth("type", 200);
            table.addContainerProperty("desc", String.class, null, messages.getString("tableCaptionDescription"), null, null);
            table.addContainerProperty("name", String.class, null, messages.getString("tableCaptionName"), null, null);
            table.setColumnWidth("name", 200);
            table.addContainerProperty("actions", TableExecButtonBar.class, null, messages.getString("tableCaptionActions"), null, null);
            table.setColumnWidth("actions", 50);
        } else {
            table.addContainerProperty("id", String.class, null, "id", null, null);
            table.setColumnWidth("id", 30);
            table.addContainerProperty("type", TableComboBox.class, null, messages.getString("tableCaptionSection"), null, null);
            table.setColumnWidth("type", 200);
            table.addContainerProperty("desc", TextField.class, null, messages.getString("tableCaptionDescription"), null, null);
            table.addContainerProperty("name", String.class, null, messages.getString("tableCaptionName"), null, null);
            table.setColumnWidth("name", 200);
            table.addContainerProperty("actions", TableExecButtonBar.class, null, messages.getString("tableCaptionActions"), null, null);
            table.setColumnWidth("actions", 50);
        }
    }

    @Override
    public void refreshTable() {
        try {
            table.removeAllItems();
            ArrayList<PbAttachment> attachments = hutil.findProcessPbAttachments(processUUID);
            for (PbAttachment attachment : attachments) {
                Item woItem = table.addItem(attachment);
                if (readonly) {
                    woItem.getItemProperty("id").setValue(attachment.getId());
                    woItem.getItemProperty("type").setValue(attachment.getFileType());
                    woItem.getItemProperty("name").setValue(attachment.getFileName());
                    woItem.getItemProperty("desc").setValue(attachment.getFileDesc());
                    TableExecButtonBar tebb = new TableExecButtonBar();
                    tebb.addButton(new TableExecButton(messages.getString("btnOpen"), "icons/document.png", attachment, this, Constants.ACTION_OPEN));
                    woItem.getItemProperty("actions").setValue(tebb);
                } else {
                    woItem.getItemProperty("id").setValue(attachment.getId());
                    woItem.getItemProperty("type").setValue(getTypeComboBox(attachment));
                    woItem.getItemProperty("name").setValue(attachment.getFileName());
                    woItem.getItemProperty("desc").setValue(getDescTextField(attachment));
                    TableExecButtonBar tebb = new TableExecButtonBar();
                    tebb.addButton(new TableExecButton(messages.getString("btnDelete"), "icons/cancel.png", attachment, this, Constants.ACTION_DELETE));
                    tebb.addButton(new TableExecButton(messages.getString("btnOpen"), "icons/document.png", attachment, this, Constants.ACTION_OPEN));
                    woItem.getItemProperty("actions").setValue(tebb);
                }
            }
            table.setSortContainerPropertyId("name");
            table.setSortAscending(false);
            table.sort();
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    private TableComboBox getTypeComboBox(PbAttachment attachment) {
        TableComboBox fileTypeComboBox = new TableComboBox(attachment);
        fileTypeComboBox.addContainerProperty("id", String.class, null);
        fileTypeComboBox.addContainerProperty("name", String.class, null);
        fileTypeComboBox.setContainerDataSource(fileTypesContainer);
        fileTypeComboBox.setItemCaptionPropertyId("name");
        fileTypeComboBox.setNewItemsAllowed(false);
        fileTypeComboBox.setWidth("100%");
        fileTypeComboBox.setValue(attachment.getFileType());
        return fileTypeComboBox;
    }

    private TextField getDescTextField(PbAttachment attachment) {
        TextField descTextField = new TextField();
        descTextField.setValue(attachment.getFileDesc());
        descTextField.setNullRepresentation("");
        descTextField.setHeight("80%");
        descTextField.setWidth("100%");
        return descTextField;
    }

    @Override
    public void buttonClick(ClickEvent event) {
        super.buttonClick(event);
        if (event.getButton() instanceof TableExecButton) {
            TableExecButton execBtn = (TableExecButton) event.getButton();
            if (execBtn.getAction().equals(Constants.ACTION_DELETE)) {
                try {
                    table.removeItem((PbAttachment) execBtn.getTableValue());
                    if (((PbAttachment) execBtn.getTableValue()).getId() > 0) {
                        toDelete.add((PbAttachment) execBtn.getTableValue());
                    }
                } catch (Exception ex) {
                    showError(ex.getMessage());
                }
            } else if (execBtn.getAction().equals(Constants.ACTION_OPEN)) {
                try {
                    PbAttachment attachment = (PbAttachment) execBtn.getTableValue();
                    ByteArraySource bas = new ByteArraySource(attachment.getFileBody());
                    StreamResource streamResource = new StreamResource(bas, attachment.getFileName(), getApplication());
                    streamResource.setCacheTime(50000); // no cache (<=0) does not work with IE8
                    streamResource.setMIMEType(attachment.getFileMimeType());
                    getWindow().getWindow().open(streamResource, "_new");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void afterDownload(PbAttachment attachment) {
        Item woItem = table.addItem(attachment);
        woItem.getItemProperty("id").setValue(attachment.getId());
        woItem.getItemProperty("type").setValue(getTypeComboBox(attachment));
        woItem.getItemProperty("name").setValue(attachment.getFileName());
        woItem.getItemProperty("desc").setValue(getDescTextField(attachment));
        TableExecButtonBar tebb = new TableExecButtonBar();
        tebb.addButton(new TableExecButton(messages.getString("btnDelete"), "icons/cancel.png", attachment, this, Constants.ACTION_DELETE));
        tebb.addButton(new TableExecButton(messages.getString("btnOpen"), "icons/document.png", attachment, this, Constants.ACTION_OPEN));
        woItem.getItemProperty("actions").setValue(tebb);
    }

    public void uploadSucceeded(SucceededEvent event) {
        try {
            PbAttachment pbAttachment = new PbAttachment();
            pbAttachment.setFileName(filename);
            pbAttachment.setFileSize(event.getLength());
            pbAttachment.setFileMimeType(MIMEType);
            byte[] readData = new byte[new Long(event.getLength()).intValue()];
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            int i = fis.read(readData);
            fis.close();
            pbAttachment.setFileBody(readData);
            afterDownload(pbAttachment);
            file.delete();
        } catch (Exception ex) {
            showError(ex.getMessage());
        }
    }

    public void uploadFailed(FailedEvent event) {
        showError(event.getFilename() + " " + event.getReason().getMessage());
    }

    public OutputStream receiveUpload(String filename, String MIMEType) {
        this.MIMEType = MIMEType;
        this.filename = filename;
        FileOutputStream fos = null;
        file = new File(filename);
        try {
            fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
            Logger.getLogger(AttachmentsPanel.class.getName()).log(Level.SEVERE, e.getMessage());
            return null;
        }
        return fos;
    }

    public void save(String processUUID, String activityUUID, String customID) {
        ArrayList<PbAttachment> pbAttachments = new ArrayList<PbAttachment>();
        for (Object object : table.getItemIds()) {
            PbAttachment attachment = (PbAttachment) object;
            attachment.setProccessUuid(processUUID);
            attachment.setActivityUuid(activityUUID);
            attachment.setCustomId(customID);
            attachment.setFileType(table.getItem(object).getItemProperty("type").getValue().toString());
            attachment.setFileDesc(table.getItem(object).getItemProperty("desc").getValue().toString());
            pbAttachments.add(attachment);
        }
        if (pbAttachments.size() > 0) {
            hutil.mergeProcessPbAttachments(pbAttachments, toDelete);
        }
        refreshTable();
    }

    public Table getTable() {
        return table;
    }
}
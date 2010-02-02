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
package org.processbase.ui.admin;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import java.util.Vector;
import org.processbase.ui.template.ACLFieldFactory;
import org.processbase.ui.template.PbWindow;
import org.processbase.util.ldap.Group;

/**
 *
 * @author mgubaidullin
 */
public class GroupWindow extends PbWindow implements ClickListener {

    public Group group = null;
    public HorizontalLayout buttons = new HorizontalLayout();
    public Button cancelBtn = new Button(messages.getString("btnClose"), this);
    public Button applyBtn = new Button(messages.getString("btnOK"), this);
    public boolean isNew = true;
    public BeanItem userBean = null;
    private Vector order = new Vector();
    private Vector fields = new Vector();
    private Form form = new Form();

    public GroupWindow(Group group) {
        super();
        this.group = group;
        if (this.group != null) {
            this.isNew = false;
        }
    }

    public void exec() {
        try {
            if (isNew) {
                group = new Group();
            }
            setCaption(messages.getString("groupWindowCaption"));
            order.add("groupname");
            order.add("groupemail");
            fields.addAll(order);
            userBean = new BeanItem(group, fields);
            form.setItemDataSource(userBean);
            form.setFormFieldFactory(new ACLFieldFactory(messages));
            form.setVisibleItemProperties(order);
            form.setWriteThrough(false);
            form.setInvalidCommitted(false);
            setModal(true);
            VerticalLayout layout = (VerticalLayout) this.getContent();
            layout.setMargin(true);
            layout.setSpacing(true);
            layout.setSizeUndefined();
            buttons.setSpacing(true);
            buttons.addComponent(applyBtn);
            buttons.addComponent(cancelBtn);
            form.getLayout().addComponent(buttons);
            addComponent(form);
            setResizable(false);
        } catch (Exception ex) {
            showError(ex.getMessage());
        }

    }

    public void buttonClick(ClickEvent event) {
        if (event.getButton().equals(cancelBtn)) {
            form.discard();
        } else {
            form.commit();
//            group.setPbtype("APP");
//            HibernateUtil hutil = new HibernateUtil();
//            hutil.merge(group);
        }
        close();
    }
}
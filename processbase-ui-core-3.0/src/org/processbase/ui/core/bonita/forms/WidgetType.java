//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.28 at 10:52:32 PM ALMT 
//


package org.processbase.ui.core.bonita.forms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WidgetType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WidgetType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MESSAGE"/>
 *     &lt;enumeration value="TEXT"/>
 *     &lt;enumeration value="TEXTAREA"/>
 *     &lt;enumeration value="RICH_TEXTAREA"/>
 *     &lt;enumeration value="TEXTBOX"/>
 *     &lt;enumeration value="RADIOBUTTON_GROUP"/>
 *     &lt;enumeration value="LISTBOX_SIMPLE"/>
 *     &lt;enumeration value="LISTBOX_MULTIPLE"/>
 *     &lt;enumeration value="SUGGESTBOX"/>
 *     &lt;enumeration value="CHECKBOX"/>
 *     &lt;enumeration value="CHECKBOX_GROUP"/>
 *     &lt;enumeration value="DATE"/>
 *     &lt;enumeration value="DURATION"/>
 *     &lt;enumeration value="PASSWORD"/>
 *     &lt;enumeration value="FILEUPLOAD"/>
 *     &lt;enumeration value="FILEDOWNLOAD"/>
 *     &lt;enumeration value="IMAGE"/>
 *     &lt;enumeration value="TABLE"/>
 *     &lt;enumeration value="EDITABLE_GRID"/>
 *     &lt;enumeration value="IFRAME"/>
 *     &lt;enumeration value="HIDDEN"/>
 *     &lt;enumeration value="BUTTON"/>
 *     &lt;enumeration value="BUTTON_SUBMIT"/>
 *     &lt;enumeration value="BUTTON_NEXT"/>
 *     &lt;enumeration value="BUTTON_PREVIOUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WidgetType")
@XmlEnum
public enum WidgetType {

    MESSAGE,
    TEXT,
    TEXTAREA,
    RICH_TEXTAREA,
    TEXTBOX,
    RADIOBUTTON_GROUP,
    LISTBOX_SIMPLE,
    LISTBOX_MULTIPLE,
    SUGGESTBOX,
    CHECKBOX,
    CHECKBOX_GROUP,
    DATE,
    DURATION,
    PASSWORD,
    FILEUPLOAD,
    FILEDOWNLOAD,
    IMAGE,
    TABLE,
    EDITABLE_GRID,
    IFRAME,
    HIDDEN,
    BUTTON,
    BUTTON_SUBMIT,
    BUTTON_NEXT,
    BUTTON_PREVIOUS;

    public String value() {
        return name();
    }

    public static WidgetType fromValue(String v) {
        return valueOf(v);
    }

}

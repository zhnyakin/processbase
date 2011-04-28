//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.28 at 10:52:32 PM ALMT 
//


package org.processbase.ui.core.bonita.forms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WidgetGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WidgetGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="variable-bound" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="style" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="label-style" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="label-position" type="{}ItemPosition" minOccurs="0"/>
 *         &lt;element name="allow-html-in-label" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="initial-value" type="{}FieldValue" minOccurs="0"/>
 *         &lt;element name="multi-instantiated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="max-instances" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="min-instances" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="add-label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="add-label-style" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="add-title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remove-label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remove-label-style" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remove-title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dependencies" type="{}Dependencies" minOccurs="0"/>
 *         &lt;element name="display-after-event" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="value-after-event" type="{}FieldValue" minOccurs="0"/>
 *         &lt;element name="widgets" type="{}Widgets" minOccurs="0"/>
 *         &lt;element name="rows-styles" type="{}RowsStyles" minOccurs="0"/>
 *         &lt;element name="columns-styles" type="{}ColumnsStyles" minOccurs="0"/>
 *         &lt;element name="widget-position" type="{}WidgetPosition" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WidgetGroup", propOrder = {

})
public class WidgetGroup {

    @XmlElement(name = "variable-bound")
    protected String variableBound;
    protected String title;
    protected String style;
    protected String label;
    @XmlElement(name = "label-style")
    protected String labelStyle;
    @XmlElement(name = "label-position")
    protected ItemPosition labelPosition;
    @XmlElement(name = "allow-html-in-label")
    protected Boolean allowHtmlInLabel;
    @XmlElement(name = "initial-value")
    protected FieldValue initialValue;
    @XmlElement(name = "multi-instantiated")
    protected Boolean multiInstantiated;
    @XmlElement(name = "max-instances")
    protected String maxInstances;
    @XmlElement(name = "min-instances")
    protected String minInstances;
    @XmlElement(name = "add-label")
    protected String addLabel;
    @XmlElement(name = "add-label-style")
    protected String addLabelStyle;
    @XmlElement(name = "add-title")
    protected String addTitle;
    @XmlElement(name = "remove-label")
    protected String removeLabel;
    @XmlElement(name = "remove-label-style")
    protected String removeLabelStyle;
    @XmlElement(name = "remove-title")
    protected String removeTitle;
    protected Dependencies dependencies;
    @XmlElement(name = "display-after-event")
    protected Boolean displayAfterEvent;
    @XmlElement(name = "value-after-event")
    protected FieldValue valueAfterEvent;
    protected Widgets widgets;
    @XmlElement(name = "rows-styles")
    protected RowsStyles rowsStyles;
    @XmlElement(name = "columns-styles")
    protected ColumnsStyles columnsStyles;
    @XmlElement(name = "widget-position")
    protected WidgetPosition widgetPosition;
    @XmlAttribute(name = "id", required = true)
    protected String id;

    /**
     * Gets the value of the variableBound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariableBound() {
        return variableBound;
    }

    /**
     * Sets the value of the variableBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariableBound(String value) {
        this.variableBound = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the labelStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelStyle() {
        return labelStyle;
    }

    /**
     * Sets the value of the labelStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelStyle(String value) {
        this.labelStyle = value;
    }

    /**
     * Gets the value of the labelPosition property.
     * 
     * @return
     *     possible object is
     *     {@link ItemPosition }
     *     
     */
    public ItemPosition getLabelPosition() {
        return labelPosition;
    }

    /**
     * Sets the value of the labelPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemPosition }
     *     
     */
    public void setLabelPosition(ItemPosition value) {
        this.labelPosition = value;
    }

    /**
     * Gets the value of the allowHtmlInLabel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAllowHtmlInLabel() {
        return allowHtmlInLabel;
    }

    /**
     * Sets the value of the allowHtmlInLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAllowHtmlInLabel(Boolean value) {
        this.allowHtmlInLabel = value;
    }

    /**
     * Gets the value of the initialValue property.
     * 
     * @return
     *     possible object is
     *     {@link FieldValue }
     *     
     */
    public FieldValue getInitialValue() {
        return initialValue;
    }

    /**
     * Sets the value of the initialValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldValue }
     *     
     */
    public void setInitialValue(FieldValue value) {
        this.initialValue = value;
    }

    /**
     * Gets the value of the multiInstantiated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMultiInstantiated() {
        return multiInstantiated;
    }

    /**
     * Sets the value of the multiInstantiated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMultiInstantiated(Boolean value) {
        this.multiInstantiated = value;
    }

    /**
     * Gets the value of the maxInstances property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxInstances() {
        return maxInstances;
    }

    /**
     * Sets the value of the maxInstances property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxInstances(String value) {
        this.maxInstances = value;
    }

    /**
     * Gets the value of the minInstances property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinInstances() {
        return minInstances;
    }

    /**
     * Sets the value of the minInstances property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinInstances(String value) {
        this.minInstances = value;
    }

    /**
     * Gets the value of the addLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddLabel() {
        return addLabel;
    }

    /**
     * Sets the value of the addLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddLabel(String value) {
        this.addLabel = value;
    }

    /**
     * Gets the value of the addLabelStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddLabelStyle() {
        return addLabelStyle;
    }

    /**
     * Sets the value of the addLabelStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddLabelStyle(String value) {
        this.addLabelStyle = value;
    }

    /**
     * Gets the value of the addTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddTitle() {
        return addTitle;
    }

    /**
     * Sets the value of the addTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddTitle(String value) {
        this.addTitle = value;
    }

    /**
     * Gets the value of the removeLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoveLabel() {
        return removeLabel;
    }

    /**
     * Sets the value of the removeLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoveLabel(String value) {
        this.removeLabel = value;
    }

    /**
     * Gets the value of the removeLabelStyle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoveLabelStyle() {
        return removeLabelStyle;
    }

    /**
     * Sets the value of the removeLabelStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoveLabelStyle(String value) {
        this.removeLabelStyle = value;
    }

    /**
     * Gets the value of the removeTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoveTitle() {
        return removeTitle;
    }

    /**
     * Sets the value of the removeTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoveTitle(String value) {
        this.removeTitle = value;
    }

    /**
     * Gets the value of the dependencies property.
     * 
     * @return
     *     possible object is
     *     {@link Dependencies }
     *     
     */
    public Dependencies getDependencies() {
        return dependencies;
    }

    /**
     * Sets the value of the dependencies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dependencies }
     *     
     */
    public void setDependencies(Dependencies value) {
        this.dependencies = value;
    }

    /**
     * Gets the value of the displayAfterEvent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisplayAfterEvent() {
        return displayAfterEvent;
    }

    /**
     * Sets the value of the displayAfterEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisplayAfterEvent(Boolean value) {
        this.displayAfterEvent = value;
    }

    /**
     * Gets the value of the valueAfterEvent property.
     * 
     * @return
     *     possible object is
     *     {@link FieldValue }
     *     
     */
    public FieldValue getValueAfterEvent() {
        return valueAfterEvent;
    }

    /**
     * Sets the value of the valueAfterEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldValue }
     *     
     */
    public void setValueAfterEvent(FieldValue value) {
        this.valueAfterEvent = value;
    }

    /**
     * Gets the value of the widgets property.
     * 
     * @return
     *     possible object is
     *     {@link Widgets }
     *     
     */
    public Widgets getWidgets() {
        return widgets;
    }

    /**
     * Sets the value of the widgets property.
     * 
     * @param value
     *     allowed object is
     *     {@link Widgets }
     *     
     */
    public void setWidgets(Widgets value) {
        this.widgets = value;
    }

    /**
     * Gets the value of the rowsStyles property.
     * 
     * @return
     *     possible object is
     *     {@link RowsStyles }
     *     
     */
    public RowsStyles getRowsStyles() {
        return rowsStyles;
    }

    /**
     * Sets the value of the rowsStyles property.
     * 
     * @param value
     *     allowed object is
     *     {@link RowsStyles }
     *     
     */
    public void setRowsStyles(RowsStyles value) {
        this.rowsStyles = value;
    }

    /**
     * Gets the value of the columnsStyles property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnsStyles }
     *     
     */
    public ColumnsStyles getColumnsStyles() {
        return columnsStyles;
    }

    /**
     * Sets the value of the columnsStyles property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnsStyles }
     *     
     */
    public void setColumnsStyles(ColumnsStyles value) {
        this.columnsStyles = value;
    }

    /**
     * Gets the value of the widgetPosition property.
     * 
     * @return
     *     possible object is
     *     {@link WidgetPosition }
     *     
     */
    public WidgetPosition getWidgetPosition() {
        return widgetPosition;
    }

    /**
     * Sets the value of the widgetPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link WidgetPosition }
     *     
     */
    public void setWidgetPosition(WidgetPosition value) {
        this.widgetPosition = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}

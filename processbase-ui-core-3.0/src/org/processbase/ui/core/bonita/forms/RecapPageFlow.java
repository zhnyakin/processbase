//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.04.28 at 10:52:32 PM ALMT 
//


package org.processbase.ui.core.bonita.forms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecapPageFlow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecapPageFlow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="transient-data" type="{}TransientData" minOccurs="0"/>
 *         &lt;element name="connectors" type="{}Connectors" minOccurs="0"/>
 *         &lt;element name="recap-pages" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="recap-page" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="page-label" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="allow-html-in-label" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="page-template" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="widgets" type="{}Widgets"/>
 *                             &lt;element name="next-page" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="redirection-url" type="{}RedirectionURL" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="first-page" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecapPageFlow", propOrder = {

})
public class RecapPageFlow {

    @XmlElement(name = "transient-data")
    protected TransientData transientData;
    protected Connectors connectors;
    @XmlElement(name = "recap-pages")
    protected RecapPageFlow.RecapPages recapPages;
    @XmlElement(name = "redirection-url")
    protected RedirectionURL redirectionUrl;
    @XmlAttribute(name = "first-page")
    protected String firstPage;

    /**
     * Gets the value of the transientData property.
     * 
     * @return
     *     possible object is
     *     {@link TransientData }
     *     
     */
    public TransientData getTransientData() {
        return transientData;
    }

    /**
     * Sets the value of the transientData property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransientData }
     *     
     */
    public void setTransientData(TransientData value) {
        this.transientData = value;
    }

    /**
     * Gets the value of the connectors property.
     * 
     * @return
     *     possible object is
     *     {@link Connectors }
     *     
     */
    public Connectors getConnectors() {
        return connectors;
    }

    /**
     * Sets the value of the connectors property.
     * 
     * @param value
     *     allowed object is
     *     {@link Connectors }
     *     
     */
    public void setConnectors(Connectors value) {
        this.connectors = value;
    }

    /**
     * Gets the value of the recapPages property.
     * 
     * @return
     *     possible object is
     *     {@link RecapPageFlow.RecapPages }
     *     
     */
    public RecapPageFlow.RecapPages getRecapPages() {
        return recapPages;
    }

    /**
     * Sets the value of the recapPages property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecapPageFlow.RecapPages }
     *     
     */
    public void setRecapPages(RecapPageFlow.RecapPages value) {
        this.recapPages = value;
    }

    /**
     * Gets the value of the redirectionUrl property.
     * 
     * @return
     *     possible object is
     *     {@link RedirectionURL }
     *     
     */
    public RedirectionURL getRedirectionUrl() {
        return redirectionUrl;
    }

    /**
     * Sets the value of the redirectionUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link RedirectionURL }
     *     
     */
    public void setRedirectionUrl(RedirectionURL value) {
        this.redirectionUrl = value;
    }

    /**
     * Gets the value of the firstPage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstPage() {
        return firstPage;
    }

    /**
     * Sets the value of the firstPage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstPage(String value) {
        this.firstPage = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="recap-page" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="page-label" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="allow-html-in-label" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;element name="page-template" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="widgets" type="{}Widgets"/>
     *                   &lt;element name="next-page" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "recapPages"
    })
    public static class RecapPages {

        @XmlElement(name = "recap-page", required = true)
        protected List<RecapPageFlow.RecapPages.RecapPage> recapPages;

        /**
         * Gets the value of the recapPages property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the recapPages property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRecapPages().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RecapPageFlow.RecapPages.RecapPage }
         * 
         * 
         */
        public List<RecapPageFlow.RecapPages.RecapPage> getRecapPages() {
            if (recapPages == null) {
                recapPages = new ArrayList<RecapPageFlow.RecapPages.RecapPage>();
            }
            return this.recapPages;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="page-label" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="allow-html-in-label" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="page-template" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="widgets" type="{}Widgets"/>
         *         &lt;element name="next-page" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class RecapPage {

            @XmlElement(name = "page-label", required = true)
            protected String pageLabel;
            @XmlElement(name = "allow-html-in-label")
            protected Boolean allowHtmlInLabel;
            @XmlElement(name = "page-template")
            protected String pageTemplate;
            @XmlElement(required = true)
            protected Widgets widgets;
            @XmlElement(name = "next-page")
            protected String nextPage;
            @XmlAttribute(name = "id")
            protected String id;

            /**
             * Gets the value of the pageLabel property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPageLabel() {
                return pageLabel;
            }

            /**
             * Sets the value of the pageLabel property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPageLabel(String value) {
                this.pageLabel = value;
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
             * Gets the value of the pageTemplate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPageTemplate() {
                return pageTemplate;
            }

            /**
             * Sets the value of the pageTemplate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPageTemplate(String value) {
                this.pageTemplate = value;
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
             * Gets the value of the nextPage property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNextPage() {
                return nextPage;
            }

            /**
             * Sets the value of the nextPage property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNextPage(String value) {
                this.nextPage = value;
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

    }

}

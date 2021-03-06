//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.28 at 03:25:32 PM EST 
//


package net.opengis.wps._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.ows._2.AllowedValues;
import net.opengis.ows._2.AnyValue;
import net.opengis.ows._2.DomainMetadataType;
import net.opengis.ows._2.ValueType;
import net.opengis.ows._2.ValuesReference;


/**
 * 
 * 				A literal data domain consists of a value type and range,
 * 				and optionally a unit of measurement and a default value.
 * 			
 * 
 * <p>Java class for LiteralDataDomainType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiteralDataDomainType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/ows/2.0}AllowedValues"/>
 *           &lt;element ref="{http://www.opengis.net/ows/2.0}AnyValue"/>
 *           &lt;element ref="{http://www.opengis.net/ows/2.0}ValuesReference"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.opengis.net/ows/2.0}DataType" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ows/2.0}UOM" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ows/2.0}DefaultValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiteralDataDomainType", propOrder = {
    "allowedValues",
    "anyValue",
    "valuesReference",
    "dataType",
    "uom",
    "defaultValue"
})
@XmlSeeAlso({
    net.opengis.wps._2.LiteralDataType.LiteralDataDomain.class
})
public class LiteralDataDomainType {

    @XmlElement(name = "AllowedValues", namespace = "http://www.opengis.net/ows/2.0")
    protected AllowedValues allowedValues;
    @XmlElement(name = "AnyValue", namespace = "http://www.opengis.net/ows/2.0")
    protected AnyValue anyValue;
    @XmlElement(name = "ValuesReference", namespace = "http://www.opengis.net/ows/2.0")
    protected ValuesReference valuesReference;
    @XmlElement(name = "DataType", namespace = "http://www.opengis.net/ows/2.0")
    protected DomainMetadataType dataType;
    @XmlElement(name = "UOM", namespace = "http://www.opengis.net/ows/2.0")
    protected DomainMetadataType uom;
    @XmlElement(name = "DefaultValue", namespace = "http://www.opengis.net/ows/2.0")
    protected ValueType defaultValue;

    /**
     * Gets the value of the allowedValues property.
     * 
     * @return
     *     possible object is
     *     {@link AllowedValues }
     *     
     */
    public AllowedValues getAllowedValues() {
        return allowedValues;
    }

    /**
     * Sets the value of the allowedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllowedValues }
     *     
     */
    public void setAllowedValues(AllowedValues value) {
        this.allowedValues = value;
    }

    /**
     * Gets the value of the anyValue property.
     * 
     * @return
     *     possible object is
     *     {@link AnyValue }
     *     
     */
    public AnyValue getAnyValue() {
        return anyValue;
    }

    /**
     * Sets the value of the anyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyValue }
     *     
     */
    public void setAnyValue(AnyValue value) {
        this.anyValue = value;
    }

    /**
     * Gets the value of the valuesReference property.
     * 
     * @return
     *     possible object is
     *     {@link ValuesReference }
     *     
     */
    public ValuesReference getValuesReference() {
        return valuesReference;
    }

    /**
     * Sets the value of the valuesReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValuesReference }
     *     
     */
    public void setValuesReference(ValuesReference value) {
        this.valuesReference = value;
    }

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link DomainMetadataType }
     *     
     */
    public DomainMetadataType getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainMetadataType }
     *     
     */
    public void setDataType(DomainMetadataType value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the uom property.
     * 
     * @return
     *     possible object is
     *     {@link DomainMetadataType }
     *     
     */
    public DomainMetadataType getUOM() {
        return uom;
    }

    /**
     * Sets the value of the uom property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainMetadataType }
     *     
     */
    public void setUOM(DomainMetadataType value) {
        this.uom = value;
    }

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link ValueType }
     *     
     */
    public ValueType getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueType }
     *     
     */
    public void setDefaultValue(ValueType value) {
        this.defaultValue = value;
    }

}

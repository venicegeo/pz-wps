//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.28 at 03:25:32 PM EST 
//


package net.opengis.wps._2;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonCreator;


/**
 * Description of a process Output. 
 * 
 * 
 * 						In this use, the DescriptionType shall describe a process output.
 * 					
 * 
 * <p>Java class for OutputDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputDescriptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/wps/2.0}DescriptionType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.opengis.net/wps/2.0}DataDescription"/>
 *         &lt;element name="Output" type="{http://www.opengis.net/wps/2.0}OutputDescriptionType" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputDescriptionType", propOrder = {
    "dataDescription",
    "output"
})
public class OutputDescriptionType
    extends DescriptionType
{

    @XmlElementRef(name = "DataDescription", namespace = "http://www.opengis.net/wps/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends DataDescriptionType> dataDescription;
    @XmlElement(name = "Output")
    protected List<OutputDescriptionType> output;

    /**
     * Gets the value of the dataDescription property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LiteralDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BoundingBoxData }{@code >}
     *     {@link JAXBElement }{@code <}{@link ComplexDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DataDescriptionType }{@code >}
     *     
     */
    public JAXBElement<? extends DataDescriptionType> getDataDescription() {
        return dataDescription;
    }

    /**
     * Sets the value of the dataDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LiteralDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BoundingBoxData }{@code >}
     *     {@link JAXBElement }{@code <}{@link ComplexDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DataDescriptionType }{@code >}
     *     
     */
    public void setDataDescription(JAXBElement<? extends DataDescriptionType> value) {
        this.dataDescription = value;
    }

    /**
     * Gets the value of the output property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the output property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputDescriptionType }
     * 
     * 
     */
    public List<OutputDescriptionType> getOutput() {
        if (output == null) {
            output = new ArrayList<OutputDescriptionType>();
        }
        return this.output;
    }
    
    @JsonCreator()
    public OutputDescriptionType() {}

}

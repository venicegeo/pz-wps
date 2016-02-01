//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.27 at 04:17:31 PM EST 
//


package net.opengis.wps._1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Description of a process Output. 
 * 
 * In this use, the DescriptionType shall describe this process output. 
 * 
 * <p>Java class for OutputDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputDescriptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/wps/1.0.0}DescriptionType">
 *       &lt;group ref="{http://www.opengis.net/wps/1.0.0}OutputFormChoice"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputDescriptionType", propOrder = {
    "complexOutput",
    "literalOutput",
    "boundingBoxOutput"
})
public class OutputDescriptionType
    extends DescriptionType
{

    @XmlElement(name = "ComplexOutput", namespace = "")
    protected SupportedComplexDataType complexOutput;
    @XmlElement(name = "LiteralOutput", namespace = "")
    protected LiteralOutputType literalOutput;
    @XmlElement(name = "BoundingBoxOutput", namespace = "")
    protected SupportedCRSsType boundingBoxOutput;

    /**
     * Gets the value of the complexOutput property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedComplexDataType }
     *     
     */
    public SupportedComplexDataType getComplexOutput() {
        return complexOutput;
    }

    /**
     * Sets the value of the complexOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedComplexDataType }
     *     
     */
    public void setComplexOutput(SupportedComplexDataType value) {
        this.complexOutput = value;
    }

    /**
     * Gets the value of the literalOutput property.
     * 
     * @return
     *     possible object is
     *     {@link LiteralOutputType }
     *     
     */
    public LiteralOutputType getLiteralOutput() {
        return literalOutput;
    }

    /**
     * Sets the value of the literalOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiteralOutputType }
     *     
     */
    public void setLiteralOutput(LiteralOutputType value) {
        this.literalOutput = value;
    }

    /**
     * Gets the value of the boundingBoxOutput property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedCRSsType }
     *     
     */
    public SupportedCRSsType getBoundingBoxOutput() {
        return boundingBoxOutput;
    }

    /**
     * Sets the value of the boundingBoxOutput property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedCRSsType }
     *     
     */
    public void setBoundingBoxOutput(SupportedCRSsType value) {
        this.boundingBoxOutput = value;
    }

}

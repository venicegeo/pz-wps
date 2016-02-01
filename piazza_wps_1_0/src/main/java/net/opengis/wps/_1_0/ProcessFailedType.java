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
import net.opengis.ows._1.ExceptionReport;


/**
 * Indicator that the process has failed to execute successfully. The reason for failure is given in the exception report. 
 * 
 * <p>Java class for ProcessFailedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessFailedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}ExceptionReport"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessFailedType", propOrder = {
    "exceptionReport"
})
public class ProcessFailedType {

    @XmlElement(name = "ExceptionReport", namespace = "http://www.opengis.net/ows/1.1", required = true)
    protected ExceptionReport exceptionReport;

    /**
     * Gets the value of the exceptionReport property.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionReport }
     *     
     */
    public ExceptionReport getExceptionReport() {
        return exceptionReport;
    }

    /**
     * Sets the value of the exceptionReport property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionReport }
     *     
     */
    public void setExceptionReport(ExceptionReport value) {
        this.exceptionReport = value;
    }

}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.28 at 03:25:32 PM EST 
//


package net.opengis.wps._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DataTransmissionModeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DataTransmissionModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="value"/>
 *     &lt;enumeration value="reference"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DataTransmissionModeType")
@XmlEnum
public enum DataTransmissionModeType {

    @XmlEnumValue("value")
    VALUE("value"),
    @XmlEnumValue("reference")
    REFERENCE("reference");
    private final String value;

    DataTransmissionModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DataTransmissionModeType fromValue(String v) {
        for (DataTransmissionModeType c: DataTransmissionModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
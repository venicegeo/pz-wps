//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.18 at 10:17:54 AM EST 
//


package net.opengis.ows._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="Get" type="{http://www.opengis.net/ows/2.0}RequestMethodType"/>
 *         &lt;element name="Post" type="{http://www.opengis.net/ows/2.0}RequestMethodType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getOrPost"
})
@XmlRootElement(name = "HTTP")
public class HTTP {

    @XmlElementRefs({
        @XmlElementRef(name = "Get", namespace = "http://www.opengis.net/ows/2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Post", namespace = "http://www.opengis.net/ows/2.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<RequestMethodType>> getOrPost;

    /**
     * Gets the value of the getOrPost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getOrPost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetOrPost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link RequestMethodType }{@code >}
     * {@link JAXBElement }{@code <}{@link RequestMethodType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<RequestMethodType>> getGetOrPost() {
        if (getOrPost == null) {
            getOrPost = new ArrayList<JAXBElement<RequestMethodType>>();
        }
        return this.getOrPost;
    }

}

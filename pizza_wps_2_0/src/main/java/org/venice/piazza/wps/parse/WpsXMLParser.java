package org.venice.piazza.wps.parse;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.opengis.wps._2.ExecuteRequestType;
import net.opengis.wps._2.ProcessOfferings;

public class WpsXMLParser {
	JAXBContext jaxbContext;
	Unmarshaller unmarshaller;
	public Boolean init() {
		Boolean retVal = true;
		try {
			jaxbContext = JAXBContext.newInstance(net.opengis.wps._2.ObjectFactory.class,net.opengis.ows._2.ObjectFactory.class);
			unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			
			e.printStackTrace();
			return false;
		}
		return retVal;
		
	}
	public ProcessOfferings parseProcessOfferingsInput(InputStream is) {
		ProcessOfferings retVal = null;
		try {
			retVal = (ProcessOfferings)unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
		
		return retVal;
	}
	
	public ExecuteRequestType parseExecuteRequestTypeInput(InputStream is) {
		ExecuteRequestType retVal = null;
		try {
			JAXBElement unmarshalledObject = 
					(JAXBElement)unmarshaller.unmarshal(is);
			retVal = (ExecuteRequestType)unmarshalledObject.getValue();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
	}

}

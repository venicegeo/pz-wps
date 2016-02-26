package org.venice.piazza.wps.parse;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBElement;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import net.opengis.wps._2.ExecuteRequestType;
import net.opengis.wps._2.ProcessOfferings;
import wps.test.elementdatadescdes;

public class WpsJsonParser {
	ObjectMapper mapper = new ObjectMapper();
	public void init() {
		mapper.setSerializationInclusion(Include.NON_NULL);
		AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(mapper.getTypeFactory()); 
		mapper.setAnnotationIntrospector(introspector);
		SimpleModule module = new SimpleModule();
	    
	    module.addDeserializer(JAXBElement.class, new elementdatadescdes());
	    mapper.registerModule(module);
	}
	
	public ProcessOfferings parseProcessOfferingsInput(InputStream is) {
		ProcessOfferings retVal = null;
		try {
			retVal = mapper.readValue(is,ProcessOfferings.class);
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
		return retVal;
	}
	
	public ExecuteRequestType parseExecuteRequestTypeInput(InputStream is) {
		ExecuteRequestType retVal = null;
		try {
			JAXBElement elem = mapper.readValue(is,JAXBElement.class);
			retVal = (ExecuteRequestType)elem.getValue();
		} catch (IOException e) {
			
			e.printStackTrace();
			return null;
		}
		return retVal;
	}

}

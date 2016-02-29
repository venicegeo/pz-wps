/*******************************************************************************
 * Copyright 2016, RadiantBlue Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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

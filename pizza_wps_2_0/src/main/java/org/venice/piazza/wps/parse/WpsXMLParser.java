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

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
package wps.test;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.opengis.wps._2.ObjectFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

public class WPSExecuteInputsTest {
	public static void main(String[] args) {
		JAXBContext jaxbContext;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		ObjectFactory factory = new ObjectFactory();
		
		try {
			jaxbContext = JAXBContext.newInstance(net.opengis.wps._2.ObjectFactory.class,net.opengis.ows._2.ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		    Marshaller marshaller = jaxbContext.createMarshaller();
		   
		    
			JAXBElement unmarshalledObject = 
					(JAXBElement)unmarshaller.unmarshal(ClassLoader.getSystemResourceAsStream("ExecuteInputs.xml"));
					//(JAXBElement)unmarshaller.unmarshal(ClassLoader.getSystemResourceAsStream("edummy.xml"));
							
			
			AnnotationIntrospector introspector =
				        new JaxbAnnotationIntrospector(mapper.getTypeFactory());   

		    mapper.setAnnotationIntrospector(introspector);
		    
		    String wpspoString = mapper.writer(new DefaultPrettyPrinter()).writeValueAsString(unmarshalledObject);
		    System.out.println(wpspoString);
		    SimpleModule module = new SimpleModule();
		    
		    module.addDeserializer(JAXBElement.class, new elementdatadescdes());
		    mapper.registerModule(module);
		    JAXBElement ert = mapper.readValue(wpspoString, JAXBElement.class);

		} catch (JAXBException e) {;
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

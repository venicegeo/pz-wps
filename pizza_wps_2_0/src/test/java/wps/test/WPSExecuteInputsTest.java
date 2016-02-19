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

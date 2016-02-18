package wps.test;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.opengis.wps._2.ObjectFactory;
import net.opengis.wps._2.ProcessOfferings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;


 



public class WPSSamplesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 //1. We need to create JAXContext instance
	    JAXBContext jaxbContext;
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			ObjectFactory factory = new ObjectFactory();
			/*InputDescriptionType idt = factory.createInputDescriptionType();
			String idtString = mapper.writeValueAsString(idt);
			InputDescriptionType idtr = mapper.readValue(idtString,InputDescriptionType.class);*/
			
			/*ComplexDataType cdt = factory.createComplexDataType();
			String cdtString = mapper.writeValueAsString(cdt);
			ComplexDataType cdtr = mapper.readValue(cdtString,ComplexDataType.class);
			
			LiteralDataType ldt = factory.createLiteralDataType();
			String ldtString = mapper.writeValueAsString(ldt);
			LiteralDataType ldtr = mapper.readValue(ldtString,LiteralDataType.class);
			
			net.opengis.ows._2.ObjectFactory owsFactory = new net.opengis.ows._2.ObjectFactory();
			MetadataType metadataType = owsFactory.createMetadataType();
			String mdtString = mapper.writeValueAsString(metadataType);
			MetadataType mdtr = mapper.readValue(mdtString,MetadataType.class);
			
			TypeType testType = TypeType.fromValue("simple");
			String typeString = mapper.writeValueAsString(testType);
			TypeType ttr = mapper.readValue(typeString,TypeType.class);
			
			OutputDescriptionType odt = factory.createOutputDescriptionType();
			String odtString = mapper.writeValueAsString(odt);
			OutputDescriptionType odtr = mapper.readValue(odtString,OutputDescriptionType.class);
			
			owsFactory.createBoundingBoxType();
			*/
			
			
			jaxbContext = JAXBContext.newInstance(net.opengis.wps._2.ObjectFactory.class,net.opengis.ows._2.ObjectFactory.class);
			
			//2. Use JAXBContext instance to create the Unmarshaller.
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		    Marshaller marshaller = jaxbContext.createMarshaller();

		    //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
		    /*InputDescriptionType unmarshalledObject = 
		       (InputDescriptionType)unmarshaller.unmarshal(
		            ClassLoader.getSystemResourceAsStream("wpsInputExample.xml"));*/
		    ProcessOfferings unmarshalledObject = 
				       (ProcessOfferings)unmarshaller.unmarshal(
				            ClassLoader.getSystemResourceAsStream("wpsProcessOfferingsExample.xml"));
		   /* marshaller.setProperty(MarshallerProperties.MEDIA_TYPE,
		    		                "application/json");*/
		    

		    AnnotationIntrospector introspector =
		        new JaxbAnnotationIntrospector(mapper.getTypeFactory());   

		    mapper.setAnnotationIntrospector(introspector);
		    
		    String wpspoString = mapper.writer(new DefaultPrettyPrinter()).writeValueAsString(unmarshalledObject);

		    System.out.println(wpspoString);
		    //String inputLine = "{         "title" : [ {           "value" : "Geometry to be buffered",           "lang" : null         } ],         "keywords" : [ ],         "identifier" : {           "value" : "INPUT_GEOMETRY",           "codeSpace" : null         },         "metadata" : [ {           "about" : null,           "type" : "SIMPLE",           "href" : "http://my.wps.server/processes/proximity/Planar-Buffer.html#input_geometry",           "role" : "http://www.opengis.net/spec/wps/2.0/def/process/description/documentation",           "arcrole" : null,           "title" : null,           "show" : null,           "actuate" : null         } ],         "dataDescription" : {           "name" : "{http://www.opengis.net/wps/2.0}ComplexData",           "declaredType" : "net.opengis.wps._2.ComplexDataType",           "scope" : "javax.xml.bind.JAXBElement$GlobalScope",           "value" : {             "format" : [ {               "mimeType" : "text/xml",               "encoding" : "UTF-8",               "schema" : "http://schemas.opengis.net/gml/3.2.1/feature.xsd",               "maximumMegabytes" : null,               "default" : true             }, {               "mimeType" : "application/json",               "encoding" : "UTF-8",               "schema" : null,               "maximumMegabytes" : null,               "default" : null             } ],             "any" : [ ]           },           "nil" : false,           "globalScope" : true,           "typeSubstituted" : false         },         "input" : [ ],         "minOccurs" : 1,         "maxOccurs" : "1",         "abstract" : [ {           "value" : "Simple Features geometry input in GML or GeoJson",           "lang" : null         } ]       }";
		    
		  /* mapper.registerModule(new JaxbAnnotationModule());
		    mapper.registerModule(new JAXBElementModule(ObjectFactory.class,net.opengis.ows._2.ObjectFactory.class));*/
		    
		    SimpleModule module = new SimpleModule();
		    
		    module.addDeserializer(JAXBElement.class, new elementdatadescdes());
		    mapper.registerModule(module);
		     
		    
		    
		    
		    
		    //InputDescriptionType prof = mapper.readValue(wpspoString,InputDescriptionType.class);
		    ProcessOfferings prof = mapper.readValue(wpspoString,ProcessOfferings.class);
		    
		    System.out.println("dogs");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    


	}

}

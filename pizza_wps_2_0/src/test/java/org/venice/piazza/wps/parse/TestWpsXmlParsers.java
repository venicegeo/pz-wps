package org.venice.piazza.wps.parse;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import net.opengis.ows._2.MetadataType;
import net.opengis.wps._2.ComplexDataType;
import net.opengis.wps._2.ExecuteRequestType;
import net.opengis.wps._2.Format;
import net.opengis.wps._2.InputDescriptionType;
import net.opengis.wps._2.ProcessDescriptionType;
import net.opengis.wps._2.ProcessOffering;
import net.opengis.wps._2.ProcessOfferings;;

public class TestWpsXmlParsers {
	WpsXMLParser parser = null;
	@Before 
	public void setup() {
		parser = new WpsXMLParser();
		parser.init();
	}

	@Test
	public void testProcessOfferingsParse() {
		InputStream is = ClassLoader.getSystemResourceAsStream("wpsProcessOfferingsExample.xml");
		ProcessOfferings testVal = parser.parseProcessOfferingsInput(is);
		assertNotNull(testVal);
		ProcessOffering offering = testVal.getProcessOffering().get(0);
		ProcessDescriptionType description = offering.getProcess();
		System.out.println(description.getIdentifier().getValue());
		assertTrue(description.getIdentifier().getValue().contains("Planar-Buffer"));
		List<InputDescriptionType> inputs = description.getInput();
		Format format = (Format)(((ComplexDataType)inputs.get(0).getDataDescription().getValue()).getAny().get(0));
		assertTrue(format.getMimeType().contains("xml"));
		assertTrue(format.getSchema().contains("feature"));
		
		MetadataType mdt = (MetadataType)inputs.get(1).getMetadata().get(0).getValue();
		assertTrue(mdt.getHref().contains("distance"));
		format = (Format)(((ComplexDataType)description.getOutput().get(0).getDataDescription().getValue()).getAny().get(0));
		assertTrue(format.getMimeType().contains("xml"));
		assertTrue(format.getSchema().contains("feature"));
		mdt = (MetadataType)description.getMetadata().get(3).getValue();
		assertTrue(mdt.getHref().contains("GML-Buffer"));
		
		
		
	}
	
	@Test
	public void testExecuteRequestType() {
		InputStream is = ClassLoader.getSystemResourceAsStream("ExecuteInputs.xml");
		ExecuteRequestType testVal = parser.parseExecuteRequestTypeInput(is);
		assertTrue(testVal.getIdentifier().getValue().contains("Planar-Buffer"));
		assertTrue(testVal.getInput().get(0).getId().contains("INPUT_GEOMETRY"));
		assertTrue(testVal.getInput().get(0).getReference().getHref().contains("mygmldata"));
		assertTrue(((String)testVal.getInput().get(1).getData().getContent().get(0)).contains("10"));
		assertTrue(testVal.getOutput().get(0).getId().contains("BUFFERED_GEOMETRY"));
		assertTrue(testVal.getOutput().get(0).getTransmission().name().contains("REFERENCE"));
		 
		
	}

}

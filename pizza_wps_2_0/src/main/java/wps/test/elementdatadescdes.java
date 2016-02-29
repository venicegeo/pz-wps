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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import net.opengis.ows._2.MetadataType;
import net.opengis.wps._2.ComplexDataType;
import net.opengis.wps._2.ExecuteRequestType;
import net.opengis.wps._2.LiteralDataType;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class elementdatadescdes extends JsonDeserializer<JAXBElement>{

	@Override
	public JAXBElement deserialize(JsonParser jp,
			DeserializationContext arg1) throws IOException,
			JsonProcessingException {
		JAXBElement retVal = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = jp.getCodec().readTree(jp);	
		JsonNode declaredTypeNode = node.get("declaredType");
		String declaredType = declaredTypeNode.textValue();
		
	    JsonNode descNode = node.get("value");
	    JsonParser newp = descNode.traverse();
	    if (declaredType.contains("ComplexDataType")) {
	    	ComplexDataType cdt = mapper.readValue(newp, ComplexDataType.class);
	    	retVal = new JAXBElement<ComplexDataType>(new QName("http://www.opengis.net/wps/2.0","ComplexData"), ComplexDataType.class, cdt);
	    }
	    else if (declaredType.contains("MetadataType")) {
	    	MetadataType mdt = mapper.readValue(newp, MetadataType.class);
	    	retVal = new JAXBElement<MetadataType>(new QName("http://www.opengis.net/ows/2.0","Metadata"), MetadataType.class, mdt);
	    }
	    else if (declaredType.contains("LiteralDataType")) {
	    	LiteralDataType ldt = mapper.readValue(newp, LiteralDataType.class);
	    	retVal = new JAXBElement<LiteralDataType>(new QName("http://www.opengis.net/wps/2.0","LiteralData"), LiteralDataType.class, ldt);
	    }
	    else if (declaredType.contains("ExecuteRequestType")) {
	    	ExecuteRequestType edt = mapper.readValue(newp, ExecuteRequestType.class);
	    	retVal = new JAXBElement<ExecuteRequestType>(new QName("http://www.opengis.net/wps/2.0","LiteralData"), ExecuteRequestType.class, edt);
	    }
	    
	    else {
	    	System.out.println(declaredType);
	    }
    	
		return retVal;
	}

}

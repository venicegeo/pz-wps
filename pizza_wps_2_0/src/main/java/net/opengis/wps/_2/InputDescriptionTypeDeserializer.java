package net.opengis.wps._2;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;

public class InputDescriptionTypeDeserializer extends JsonDeserializer<InputDescriptionType>{

	@Override
	public InputDescriptionType deserialize(JsonParser jp,
			DeserializationContext arg1) throws IOException,
			JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference ref = new TypeReference<ComplexDataType>(){};
		ObjectCodec oc = jp.getCodec();
	    JsonNode nodes = oc.readTree(jp);
	    JsonNode descNode = nodes.get("dataDescription");
	   
	    if (!descNode.isNull()) {
	    	JsonParser newp = descNode.traverse();
	    	mapper.readValue(newp, ComplexDataType.class);
	    	System.out.println();
	    }
		/*String fieldName = null;
		
		while (jp.hasCurrentToken()) {
			JsonToken token = jp.nextToken();
			
			if (token == JsonToken.FIELD_NAME) {
                fieldName = jp.getCurrentName();
                if (fieldName.contains("dataDesc")) {
                	System.out.println(jp.getText());
                	
                	token = jp.nextValue();
                	System.out.println(jp.getText());
                	jp.g
                	if (token == JsonToken.START_OBJECT) {
                		System.out.println(jp.getText());
                		while (token != JsonToken.END_OBJECT) {
                			token = jp.nextToken();
                			System.out.println(jp.getText());
                			
                		}
                	}
                }
                System.out.println(fieldName);
           } 
			
		}*/
		return null;
	}

}

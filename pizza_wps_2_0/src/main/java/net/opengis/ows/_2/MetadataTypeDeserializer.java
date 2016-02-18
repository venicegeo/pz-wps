package net.opengis.ows._2;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class MetadataTypeDeserializer extends JsonDeserializer<MetadataType>{

	@Override
	public MetadataType deserialize(JsonParser jp, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		JsonToken currentToken = jp.getCurrentToken();
		/*ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);*/
		return null;
	}

}

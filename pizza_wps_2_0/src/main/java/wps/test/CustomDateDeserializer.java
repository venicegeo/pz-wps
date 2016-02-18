package wps.test;

import java.io.IOException;

import net.opengis.wps._2.ProcessOffering;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;

public class CustomDateDeserializer extends UntypedObjectDeserializer {
	private static final long serialVersionUID = -2275951539867772400L;

    @Override
    public ProcessOffering deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {

        if (jp.getCurrentTokenId() == JsonTokenId.ID_STRING) {
            try {
                System.out.println(jp.getText());
                return null;
            } catch (Exception e) {
            	return null;
                //return super.deserialize(jp, ctxt);
            }
        } else {
        	return null;
            //return super.deserialize(jp, ctxt);
        }
    }

}

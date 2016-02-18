package wps.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.CollectionType;


	public class JAXBElementModule extends SimpleModule {
		  Class[] classesToBind;

		  public JAXBElementModule() {}

		  public JAXBElementModule(Class ... classesToBind) {
		    this.classesToBind = classesToBind;
		  }

		  @Override
		  public void setupModule(SetupContext context) {
		    super.setupModule(context);

		    if (classesToBind != null) {
		      context.setMixInAnnotations(JAXBElement.class, KeepDeclaredType.class);
		    } else {
		      context.setMixInAnnotations(JAXBElement.class, IgnoreDeclaredType.class);
		    }

		    context.addBeanDeserializerModifier(
		      new BeanDeserializerModifier() {
		        @Override
		        public JsonDeserializer<?> modifyCollectionDeserializer(DeserializationConfig config, CollectionType type, BeanDescription beanDesc, JsonDeserializer<?> deserializer) {
		          if (type.getContentType().getRawClass() == Object.class) {
		            //return new XMLAnyElementDeserializer((CollectionDeserializer) deserializer);
		        	  return new UntypedObjectDeserializer();
		          }
		          return deserializer;
		        }
		      });
		    SimpleDeserializers deserializers = new SimpleDeserializers();
		    deserializers.addDeserializer(JAXBElement.class, new JAXBElementDeserializer(classesToBind));
		    context.addDeserializers(deserializers);
		  }

		  // Serialization mixins used to ignore fields that are unused by the deserializer
		  abstract public class KeepDeclaredType {
		    @JsonIgnore abstract String getScope();
		    @JsonIgnore abstract boolean isNil();
		    @JsonIgnore abstract boolean isGlobalScope();
		    @JsonIgnore abstract boolean isTypeSubstituted();
		  }
		  abstract public class IgnoreDeclaredType {
		    @JsonIgnore abstract String getScope();
		    @JsonIgnore abstract boolean isNil();
		    @JsonIgnore abstract boolean isGlobalScope();
		    @JsonIgnore abstract boolean isTypeSubstituted();
		    @JsonIgnore abstract Class getDeclaredType();
		  }

		  class JAXBElementDeserializer extends StdDeserializer<JAXBElement<?>> {
		    Class [] classesToBind;

		    protected JAXBElementDeserializer(Class ... classesToBind) {
		      super(JAXBElement.class);
		      this.classesToBind = classesToBind;
		    }

		    @Override
		    public JAXBElement<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		    
		      if (!p.isExpectedStartArrayToken()) {
		        return null;
		      }

		      Class declaredType = null;
		      String name = "undef";
		      Object value = null;

		      JsonToken currentToken;
		      while ((currentToken = p.nextValue()) != JsonToken.END_OBJECT) {
		        switch (currentToken) {
		          case VALUE_STRING:
		            switch (p.getCurrentName()) {
		              case "declaredType":
		                try {
		                  declaredType = ctxt.findClass(p.getText());
		                } catch (ClassNotFoundException e) {
		                  // leave declaredType null
		                }
		                break;
		              case "name":
		                name = p.getText();
		                if (declaredType == null) declaredType = typeFor(qNameFromString(name));
		                break;
		              case "value":
		                value = p.getText();
		                break;
		              default:
		            }
		            break;
		          case START_OBJECT:
		            if (declaredType == null) declaredType = LinkedHashMap.class;
		            value = ctxt.readValue(p, declaredType);
		            break;
		          case START_ARRAY:
		            if (declaredType == null) declaredType = List.class;
		            value = ctxt.readValue(p, declaredType);
		            break;
		          case VALUE_NUMBER_INT:
		            value = p.getLongValue();
		            break;
		          case VALUE_NUMBER_FLOAT:
		            value = p.getDoubleValue();
		            break;
		          case VALUE_TRUE:
		            value = Boolean.TRUE;
		            break;
		          case VALUE_FALSE:
		            value = Boolean.FALSE;
		            break;
		          case VALUE_NULL:
		            value = null;
		            break;
		          case NOT_AVAILABLE:
		          case END_OBJECT:
		          case END_ARRAY:
		          case FIELD_NAME:
		          case VALUE_EMBEDDED_OBJECT:
		            break;
		          default:
		        }
		      }
		      if (declaredType == null) declaredType = value.getClass();
		      return new JAXBElement<>(qNameFromString(name), declaredType, value);
		    }

		  QName qNameFromString(String s) {
		    String[] parts = s.split("[{}]");
		    if (parts.length > 2) return new QName(parts[1], parts[2]);
		    if (parts.length == 1) return new QName(parts[0]);
		    return new QName("undef");
		  }

		  Class typeFor(QName qname) {
		    if (classesToBind == null) return null;
		    for (Class objectFactoryClass : classesToBind) {
		      if (objectFactoryClass != null) {
		        Method[] methods = objectFactoryClass.getDeclaredMethods();
		        for (Method method : methods) {
		          XmlElementDecl decl = method.getAnnotation(XmlElementDecl.class);
		          if (decl != null && qNameMatches(qname, decl.namespace(), decl.name())) {
		            return method.getParameterTypes()[0];
		          }
		        }
		      }
		    }
		    return null;
		  }

		  private boolean qNameMatches(QName qName, String namespace, String localPart) {
		   return (qName.getNamespaceURI() == null ? namespace == null : qName.getNamespaceURI().equals(namespace)) &&
		          (qName.getLocalPart() == null ? localPart == null : qName.getLocalPart().equals(localPart));
		    }
		  }
		}



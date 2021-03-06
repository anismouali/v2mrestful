package com.ahajri.v2m.domain.json.serialization;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.ahajri.v2m.domain.Person;
import com.ahajri.v2m.domain.Receiver;

public class ReceiverDeserializer extends JsonDeserializer<Receiver> {

	@Override
	public Receiver deserialize(JsonParser jsonParser,
			DeserializationContext context) throws IOException,
			JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
		JsonNode node = oc.readTree(jsonParser);
		Receiver domain = new Receiver();
		domain.setId(node.get("id").getLongValue());
		JsonNode personNode = node.path("person");
		Person person = new Person();
		person.setEmail(personNode.get("email").getTextValue());
		person.setId(personNode.get("id").getLongValue());
		person.setFullName(personNode.get("fullName").getTextValue());
		domain.setPerson(person);
		return domain;
	}

}

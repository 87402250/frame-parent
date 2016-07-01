package com.zzw.service.commons;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class XmlUtils {
	public static String marshalObjectToXml(Object object) {
		StringWriter writer = new StringWriter();
		JAXB.marshal(object, writer);
		return writer.toString();
	}

	public static <T> T unmarshalXmlToObject(String xml, Class<?> clazz) {
		StringReader reader = new StringReader(xml);
		return (T) JAXB.unmarshal(reader, clazz);
	}

	public static <T> T unmarshalXmlFileToObject(String xmlPath, Class<?> clazz) throws IOException {
		String xml = Files.toString(new File(xmlPath), Charsets.UTF_8);
		StringReader reader = new StringReader(xml);
		return (T) JAXB.unmarshal(reader, clazz);
	}
}

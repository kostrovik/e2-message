package ru.kbakaras.e2.message;

import org.dom4j.Element;

import java.util.UUID;

public class E2Update extends E2Payload implements E2XmlProducer {
    public E2Update() {
        super(Use.createRoot("updateRequest", E2.NS));
    }
    public E2Update(Element xml) {
        super(xml);
    }
    public E2Update(String xmlStr) {
        super(Use.parse4Root(xmlStr));
    }


    public UUID systemUid() {
        return UUID.fromString(xml.attributeValue(E2.SYSTEM_UID));
    }

    public String systemName() {
        return xml.attributeValue(E2.SYSTEM_NAME);
    }


    public E2Update setSystemUid(String systemUid) {
        xml.addAttribute(E2.SYSTEM_UID, systemUid);
        return this;
    }

    public E2Update setSystemName(String systemName) {
        xml.addAttribute(E2.SYSTEM_NAME, systemName);
        return this;
    }

    @Override
    public Element xml() {
        reorderEntitiesAndStates();
        return xml;
    }
}
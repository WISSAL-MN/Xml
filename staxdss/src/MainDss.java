import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainDss {
    public static List<Contact> parseXML(String xml_file_path) {
        List<Contact> contact_list = new ArrayList<>();
        Contact temp_contact = null;

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml_file_path));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("contact")) {
                        temp_contact = new Contact();
                        Attribute type_attribute = startElement.getAttributeByName(new QName("type"));
                        if (type_attribute != null) {
                            temp_contact.setType(type_attribute.getValue());
                        }
                    } else if (temp_contact != null)
                        if (startElement.getName().getLocalPart().equals("lastname")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            temp_contact.setLastname(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("firstname")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            temp_contact.setFirstname(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("phone")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            temp_contact.setPhone(xmlEvent.asCharacters().getData());
                        } else if (startElement.getName().getLocalPart().equals("age")) {
                            xmlEvent = xmlEventReader.nextEvent();
                            temp_contact.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("contact")) {
                        contact_list.add(temp_contact);
                    }
                }
            }

        } catch (XMLStreamException | FileNotFoundException xmlStreamException) {
            xmlStreamException.printStackTrace();
        }

        return contact_list;
    }

    public static void main(String[] args){
        System.out.print(parseXML("C://Users//wissa//Desktop//IdeaProject//staxdss//contact.xml"));
    }
}
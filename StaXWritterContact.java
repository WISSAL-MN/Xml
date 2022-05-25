import java.io.FileOutputStream;
import java.util.Scanner;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StaXWritterContact {
    private String contactFile;

    public void setFile(String contactFile) {
        this.contactFile = contactFile;
    }
    public void saveContacts(int nombre) throws Exception {

        Scanner sc = new Scanner(System.in);
        int i;
        String firstname, lastname, phone, age;

        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(contactFile));
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");


        StartDocument startDocument = eventFactory.createStartDocument();
        eventWriter.add(startDocument);
        eventWriter.add(end);

        StartElement group = eventFactory.createStartElement("", "", "contacts");
        eventWriter.add(group);
        eventWriter.add(end);


        for(i = 0 ; i < nombre ; i++) {
            System.out.println("Contact N=°" + (i + 1));
            System.out.print("Firstname ==> ");
            firstname = sc.nextLine();

            System.out.print("Lastname ==> ");
            lastname = sc.nextLine();

            System.out.print("Phone ==> ");
            phone = sc.nextLine();

            System.out.print("Age ==> ");
            age = sc.nextLine();
            StartElement articleStartElement = eventFactory.createStartElement("", "", "contact");
            eventWriter.add(tab);
            eventWriter.add(articleStartElement);
            eventWriter.add(end);

            eventWriter.add(tab);
            createNode(eventWriter, "firstname", firstname);
            eventWriter.add(tab);
            createNode(eventWriter, "lastname", lastname);
            eventWriter.add(tab);
            createNode(eventWriter, "phone", phone);
            eventWriter.add(tab);
            createNode(eventWriter, "age", age);
            eventWriter.add(tab);


            eventWriter.add(eventFactory.createEndElement("", "", "contact"));
            eventWriter.add(end);


        }
        eventWriter.add(eventFactory.createEndElement("", "", "contacts"));
        eventWriter.add(end);


        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }
    private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");

        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);

        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);

        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }
}

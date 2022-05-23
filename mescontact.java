// les import pour les utilitaires utilisés
// Définir la classe Parser
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public classe contact {
 private String type;
 private String lastname;
 private String firstname;
 private String phone;
 private String age;
// define getters and setters for all attributes
 @Override
 public String toString() {
 return "Article [phone=" + phone + ", type=" + type + ", age="
 + age + ", lastname=" + lastname + ", firstname=" + fistname + "]";
 }
}


public class StaXParser {
 // Les cas des éléments(entrées) du document XML
 static final String Type = "type";
 static final String Contact = "contact";
 static final String Lastname = "lastname";
 static final String Firstname = "firstname";
 static final String Phone = "phone";
 static final String Age = "age" »;

// 2) Définir un nouveau eventReader
 InputStream in = new FileInputStream(mescontact);
 XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
 
 // 3) lire le document XML
 Contact contact = null;
 while (eventReader.hasNext()) {
 XMLEvent event = eventReader.nextEvent();
 if (event.isStartElement()) {
 StartElement startElement = event.asStartElement();
 String elementName = startElement.getName().getLocalPart();
 switch (elementName) {
 // traiter dans ce qui suit chaque element possible
 //…
 
 
 switch (elementName) {
 // traiter dans ce qui suit chaque element possible
 //…
 case Contact:
 contact = new Contact();
 // On lit les attributs de l’élément dans XML
 // attributs de notre element article 
Iterator<Attribute> attributes = startElement.getAttributes();
 while (attributes.hasNext()) {
 // parcourir la liste des attributs de notre élément
 Attribute attribute = attributes.next();
 // on récupère la date et on la met dans notre objet Java article
 if (attribute.getName().toString().equals(Type)) { 
 contact.setType(attribute.getValue()); 
 }
 }
 break;


//suite du switch
case Lastname:
 // lire le prochain événement (entrée du document) 
 event = eventReader.nextEvent();
// récupérer la chaine de caractères et la mettre dans Type de l’objet Java 
contact 
 contact.setLastname(event.asCharacters().getData()); 
 break;
 case UNIT:
 event = eventReader.nextEvent();
 article.setUnit(event.asCharacters().getData());
 break;
 case FOREIGN:
 event = eventReader.nextEvent();
 article.setForeign(event.asCharacters().getData());
 break;
 case SPECIAL:
 event = eventReader.nextEvent();
 article.setSpecial(event.asCharacters().getData());
 break;
 }
 } // fin switch 
} // fin de if (event.isStartElement())

// Quand on atteint la for d’un element article, on l’ajoute à la liste
 if (event.isEndElement()) {
 EndElement endElement = event.asEndElement();
 if (endElement.getName().getLocalPart().equals(Contact)) {
 contacts.add(contact);
 }
 }
 }
 } catch (FileNotFoundException | XMLStreamException e) {
 e.printStackTrace();
 }
 return contacts;
 }
}
//Tester votre classe StaXParser
import java.util.List;
public class Main {
 public static void main(String args[]) {
 StaXParser read = new StaXParser();
 List<Contact> contacts = read.readContacts("articlesFile.xml");
 for (Contact Contact : Contacts) {
 System.out.println(Contact);
 }
 }


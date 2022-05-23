for $x in doc ("contacts.xml")/contacts/contact where $x/age<15
return $x/(lastname ,firstname)   

for $x in doc ("contacts.xml")/contacts/contact where $x[@type='sim']
return $x   
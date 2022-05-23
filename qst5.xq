 for $c in doc("contacts.xml")/contacts/contact
 
  return if($c/@type = "sim")
    then <sim>{data($c/lastname)}</sim>
      else <phone>{data($c/lastname)}</phone>
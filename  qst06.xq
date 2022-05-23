<contacts>
{
for $x in doc("contacts.xml")/contacts/contact  where $x/age>11 and  $x/@type = "phone"
return 
        <person>
        { $x/lastname}
        { $x/firstname}
        { $x/phone}
        { $x/age}
        </person>
      }
</contacts>
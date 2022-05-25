public class Contact {
    private String lastname;
    private String firstname;
    private String phone;
    private int age;
    private String type;

    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Contact( "+ lastname + ", " + firstname + ", " + phone + ", " + age + ", " + type + ")\n";
    }
}

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String street;
    private String city;
    private String state;
    private int zip;

    public Person(String csvLine){
        String[] data = csvLine.split(",");

        this.id = Integer.valueOf(data[0]);
        this.firstName = data[1];
        this.lastName = data[2];
        this.age = Integer.valueOf(data[3]);
        this.street = data[4];
        this.city = data[5];
        this.state = data[6];
        this.zip = Integer.valueOf(data[7]);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getZip() {
        return zip;
    }
    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }
}

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

    public String getFirstName() {
        return firstName;
    }
    public int getAge() {
        return age;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
}

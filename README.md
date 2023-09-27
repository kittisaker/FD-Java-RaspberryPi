# FD-Java-RaspberryPi : Chapter 3 About Java

## Install Java JDK on a Raspberry Pi

### Downloading and testing BellSoft Liberica JDK

```shell
$ cd /home/pi
$ wget https://download.bell-sw.com/java/13/bellsoft-jdk13-linux-arm32-vfp-hflt.deb
$ sudo apt-get install ./bellsoft-jdk13-linux-arm32-vfp-hflt.deb
$ sudo update-alternatives --config javac
$ sudo update-alternatives --config java
$
$ java --version
openjdk 13-BellSoft 2019-09-17
OpenJDK Runtime Environment (build 13-BellSoft+33)
OpenJDK Server VM (build 13-BellSoft+33, mixed mode)
```

## Some of the changes between Java versions

### Changes between Java 8 and 11

* jshell
"jshell" was also added in version 9 which enables to quickly test Java code. To start, just type in
jshell in the terminal:

```shell
$ jshell

jshell> /help intro

jshell> var txt = "Hello!, My name is KOPE"
txt ==> "Hello!, My name is KOPE"

jshell> txt
txt ==> "Hello!, My name is KOPE"

jshell> txt + (3*8)
$3 ==> "Hello!, My name is KOPE24"

jshell> txt.substring(2, 5)
$5 ==> "llo"

jshell> txt.substring(2, 5)
$5 ==> "llo"
```

### What's next after Java 11?

#### Switch Expressions

* Java 12 first improvements
```java
switch (day) {
    case MONDAY:
    case FRIDAY:
    case SUNDAY:
    System.out.println(6);
    break;
    case TUESDAY:
    System.out.println(7);
    break;
    case THURSDAY:
    case SATURDAY:
    System.out.println(8);
    break;
    case WEDNESDAY:
    System.out.println(9);
    break;
}
```

into a shorter code block like this :

```java
switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
    case TUESDAY -> System.out.println(7);
    case THURSDAY, SATURDAY -> System.out.println(8);
    case WEDNESDAY -> System.out.println(9);
}
```

* Further extended in Java 13
```java
int numLetters = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY -> 7;
    case THURSDAY, SATURDAY -> 8;
    case WEDNESDAY -> 9;
};
```

#### Text blocks introduced in Java 13

Before :
```java
String htmlBlock = "<html>" +
    "   <body>" +
    "       <p>Welcome on my site</p>" +
    "   </body>" +
    "<html>";
```
After :

```java
String htmlBlock = """
    <html>
        <body>
            <p>Welcome on my site</p>
        </body>
    <html>
    """;
```

#### Helpful NullPointerExceptions in Java 14

```java
Exception in thread "main" java.lang.NullPointerException at
    Main.main(Unknown Source)
```

With this new functionality, the error will provide more info about the object which caused the error, so you can quickly spot the error in your code. For instance:

```java
Exception in thread "main" java.lang.NullPointerException:
    Cannot assign field "textValue" because "textBox" is null at
    Main.main(Unknown Source)
```

## java crash course

### HelloWorld! Running a single-file Java-application

```shell
$ cd /home/solokope
$ code .
```


<details>
<summary>HelloWorld.java</summary>

```java
public class HelloWorld{
    public static void main (String[] args){
        String txt = "Hello World";
        System.out.println(txt);
    }
}
```
</details>

```shell
solokope@raspberrypi:~ $ java HelloWorld.java
Hello World
```

### Using the start-up arguments

<details>
<summary>MainArguments.java</summary>

```java
public class MainArguments {
    public static void main(String[] args) {
        System.out.println("Number of arguments : " + args.length);

        if(args.length > 0){
            System.out.println("First argument : " + args[0]);
        }

        for(int i = 0; i < args.length; i++){
            System.out.println("Argument " + (i + 1) + " : " + args[i]);
        }
    }
}
```

</details>

```shell
solokope@raspberrypi:~ $ java MainArguments.java
Number of arguments : 0

solokope@raspberrypi:~ $ java MainArguments.java "Hello Kope" "Bye"
Number of arguments : 2
First argument : Hello Kope
Argument 1 : Hello Kope
Argument 2 : Bye
```

### Working with numbers

<details>
<summary>NumberValues.java</summary>

```java
public class NumberValues {
    public static void main(String[] args) {
        System.out.println("Number of arguments : " + args.length);

        if(args.length > 0){
            System.out.println("First argument : " + args[0]);
        }

        for(int i = 0; i < args.length; i++){
            System.out.println("Argument " + (i + 1) + " : " + args[i]);
        }
    }
}
```

</details>

```shell
solokope@raspberrypi:~ $ java NumberValue.java
Integer: 2
Float: 1.1234568
Double: 1.1234567890123457
Multiply: 2.2469137, rounded: 2
```


### If, Then, Else

<details>
<summary>IfThenElse.java</summary>

```java
public class IfThenElse {
    public static void main (String[] args) {
        // Compare integer value
        int piHeaderVersion = 1;

        if (piHeaderVersion == 1) {
            System.out.println("Header version 1 is used on original Model B");
        } else if (piHeaderVersion == 2) {
            System.out.println("Header version 2 is used on Model A and Model B (revision 2)");
        } else if (piHeaderVersion == 3) {
            System.out.println("Header version 3 is used on Model A+, B+, Pi Zero, Pi Zero W, Pi2B, Pi3B, Pi4B");
        } else {
            System.out.println("Sorry, header version " + piHeaderVersion + " is not known");
        }

        // Compare strings
        String string1 = "Hello world";
        String string2 = "Hello" + " " + "world";
        String string3 = "Hello World";

        System.out.println("Are string1 and string2 equal? " + string1.equals(string2));
        System.out.println("Are string1 and string3 equal? " + string1.equals(string3));
        System.out.println("Are string1 and string3 equal ignoring the case? " + string1.equalsIgnoreCase(string3));

        if (string1.equalsIgnoreCase(string3)) {
            System.out.println("string1 and string3 are equal ignoring the case");
        }
    }
}
```
</details>

```shell
$java IfThenElse.java
Header version 1 is used on original Model B
Are string1 and string2 equal? true
Are string1 and string3 equal? false
Are string1 and string3 equal ignoring the case? true
string1 and string3 are equal ignoring the case
```

### Enum and Switch

<details>
<summary>.java</summary>

```java
public class EnumSwitch {
    public static void main (String[] args) {
        // Compare integer value
        HEADER_VERSION piHeaderVersion = HEADER_VERSION.UNKNOWN;

        switch(piHeaderVersion) {
            case TYPE_1:
                System.out.println("Header version 1 is used on original Model B");
                break;
            case TYPE_2:
                System.out.println("Header version 2 is used on Model A and Model B (revision 2)");
                break;
            case TYPE_3:
                System.out.println("Header version 3 is used on Model A+, B+, Pi Zero, Pi Zero W, Pi2B, Pi3B, Pi4B");
                break;
            default:
                System.out.println("Sorry, header version " + piHeaderVersion + " is not known");
        }
    }

    enum HEADER_VERSION {
        TYPE_1, TYPE_2, TYPE_3, UNKNOWN;
    }
}
```
</details>

```
$ java EnumSwitch.java
Sorry, header version UNKNOWN is not known
```

### Using methods

<details>
<summary>UsingMethod.java</summary>

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsingMethod {
    public static void main (String[] args) {
        System.out.println("2 x Raspberry Pi 4 4Gb, price: " + getTotal(2, 59.95F) + " Euro");

        System.out.println("Current date and time is: " + getNow());
    }

    public static float getTotal(int quantity, float price) {
        return quantity * price;
    }

    public static String getNow() {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
    }
}
```
</details>

```shell
$java UsingMethod.java
2 x Raspberry Pi 4 4Gb, price: 119.9 Euro
Current date and time is: 2023.09.24 16:44:57
```

### Using objects

<details>
<summary>ShoppingCartItem.java</summary>

```java
public class ShoppingCartItem {
    private String name;
    private int quantity;
    private float price;
    
    public ShoppingCartItem(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal(){
        return this.quantity * this.price;
    }
}
```
</details>


<details>
<summary>UsingObject.java</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class UsingObject {
    public static void main(String[] args) {

        List<ShoppingCartItem> items = new ArrayList<>();

        items.add(0, new ShoppingCartItem("Raspberry Pi 4, 4Gb", 1, 59.95F));
        items.add(new ShoppingCartItem("Micro-HDMI cable", 2, 5.9F));
        items.add(new ShoppingCartItem("Raspberry Pi 4 power supply", 1, 9.95F));

        showInfo(items);
   }

   static void showInfo(List<ShoppingCartItem> items){
        double total = 0D;
        for(ShoppingCartItem item : items){
            
            System.out.println(item.getName());
            System.out.println("    " + item.getQuantity() + "\tx\t"
                + item.getPrice() + "\t= " + item.getTotal() + " Euro");
            System.out.println("Price : " + item.getPrice());
            total += item.getTotal();
        }
        System.out.println("\nTotal for shopping cart:\n   " + total + " Euro");
   }
}
```
</details>

### Reading a text file

<details>
<summary>Person.java</summary>

```java
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

```
</details>

<details>
<summary>ReadTextFile.java</summary>

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadTextFile {
    public static void main(String[] args) {
        List<Person> persons = loadPersons();

        System.out.println("Number of persons leaded from CSV file : " + persons.size());

        for(Person person : persons){
            System.out.println(person.getFullName() + ", age : " + person.getAge());
        }
    }

    public static List<Person> loadPersons(){
        List<Person> list = new ArrayList<>();

        File file = new File("resources/testdata.csv");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                list.add(new Person(scanner.nextLine()));
            }
        }catch(FileNotFoundException ex){
            System.err.println("Could not find the file to be leaded");
        }

        return list;
    }
}
```
</details>

```shell
$ java ReadTextFile       
Number of persons leaded from CSV file : 100
Ada Gomez, age : 40
Bernard Jordan, age : 28
Mittie Vaughn, age : 64
Miguel Clarke, age : 39
...
```

### Using streams

<details>
<summary>ReadTextFile.java</summary>

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Scanner;

public class ReadTextFile {
    public static void main(String[] args) {
        List<Person> persons = loadPersons();

        System.out.println("Number of persons leaded from CSV file : " + persons.size());

        for(Person person : persons){
            System.out.println(person.getFullName() + ", age : " + person.getAge());
        }

        System.out.println("------------------------------------------------"); // <-- 
        System.out.println("Number of persons with first name");
        System.out.println("    * 'Matthew':     " + countFirstName(persons, "Matthew"));
        System.out.println("    * 'Charlotte':   " + countFirstName(persons, "Charlotte"));

        System.out.println("------------------------------------------------");
        IntSummaryStatistics stats = getAgeStats(persons);
        System.out.println("Minimum age: " + stats.getMin());
        System.out.println("Maximum age: " + stats.getMax());
        System.out.println("Average age: " + stats.getAverage());
    }

    public static int countFirstName(List<Person> persons, String firstName){       // <- 
        return (int)persons.stream().filter(p -> p.getFirstName().equals(firstName)).count();
    }

    public static IntSummaryStatistics getAgeStats(List<Person> persons){           // <-
        return persons.stream().mapToInt(Person::getAge).summaryStatistics();
    }

    public static List<Person> loadPersons(){
        List<Person> list = new ArrayList<>();

        File file = new File("resources/testdata.csv");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                list.add(new Person(scanner.nextLine()));
            }
        }catch(FileNotFoundException ex){
            System.err.println("Could not find the file to be leaded");
        }

        return list;
    }
}
```
</details>

```shell
$ java ReadTextFile  
...
------------------------------------------------
Number of persons with first name
    * 'Matthew':     2
    * 'Charlotte':   4
------------------------------------------------
Minimum age: 18
Maximum age: 65
Average age: 42.78
```

---
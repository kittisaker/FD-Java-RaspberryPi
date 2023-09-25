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

        System.out.println("------------------------------------------------");
        System.out.println("Number of persons with first name");
        System.out.println("    * 'Matthew':     " + countFirstName(persons, "Matthew"));
        System.out.println("    * 'Charlotte':   " + countFirstName(persons, "Charlotte"));

        System.out.println("------------------------------------------------");
        IntSummaryStatistics stats = getAgeStats(persons);
        System.out.println("Minimum age: " + stats.getMin());
        System.out.println("Maximum age: " + stats.getMax());
        System.out.println("Average age: " + stats.getAverage());
    }

    public static int countFirstName(List<Person> persons, String firstName){
        return (int)persons.stream().filter(p -> p.getFirstName().equals(firstName)).count();
    }

    public static IntSummaryStatistics getAgeStats(List<Person> persons){
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

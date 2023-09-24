import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadTextFile {

    public static void main(String[] args) {
        List<Person> persons = loadPersons();
        System.out.println("Number of persons loaded from CSV file: " + persons.size());
    }

    public static List<Person> loadPersons(){
        List<Person> list = new ArrayList<>();

        File file = new File("resources/testdata.csv");

        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()) {
                list.add(new Person(scanner.nextLine()));
            }
        }catch(FileNotFoundException ex){
            System.err.println("Could not find the file to be loaded");
        }

        return list;
    }
}
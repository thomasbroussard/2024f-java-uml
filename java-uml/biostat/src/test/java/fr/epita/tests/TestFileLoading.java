package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TestFileLoading {

    public static void main(String[] args) throws IOException {
        File file =  new File("./biostat/biostat.csv");
        if (!file.exists()){
            System.out.println("file does not exists");
            return;
        }
        System.out.println("file exists, proceeding with data loading");
        List<String> lines = Files.readAllLines(file.toPath());
        System.out.println(lines);
        lines.remove(0);
        List<Person> persons = new ArrayList<>();
        for (String line : lines){
            //"Alex",   "M",   41,       74,      170
            Person person = new Person();
            String[] parts = line.split(",");
            System.out.println(Arrays.deepToString(parts));
            person.setName(parts[0].trim());
            person.setGender(parts[1].trim());
            person.setAge(Integer.parseInt(parts[2].trim()));
            person.setHeight(Integer.parseInt(parts[3].trim()));
            person.setWeight(Integer.parseInt(parts[4].trim()));
            persons.add(person);
        }
        System.out.println(persons.size());
        double average = 0;
        for(Person person : persons){
            average = average + person.getAge();
        }
        average = average / persons.size();
        System.out.println(" average age: " + average);

        double avg = persons.stream()
               // .mapToInt(p -> p.getAge())
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();


        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(groupingBy(Person::getAge));

        Map<Integer, List<Person>> personsByHeight = persons
                .stream()
                .collect(groupingBy(Person::getHeight));


        Map<String, List<Person>> personsByGender = persons
                .stream()
                .collect(groupingBy(Person::getGender));


        System.out.println(personsByGender);
        System.out.println(avg);

    }
}

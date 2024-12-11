package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
            person.setName(parts[0].trim());
            person.setGender(parts[1].trim());
            person.setAge(Integer.parseInt(parts[2].trim()));
            person.setHeight(Integer.parseInt(parts[3].trim()));
            person.setWeight(Integer.parseInt(parts[4].trim()));
            persons.add(person);
        }
        System.out.println(persons.size());



    }
}

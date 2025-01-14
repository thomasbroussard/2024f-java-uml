package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;
import fr.epita.biostat.services.PersonDBService;
import fr.epita.biostat.services.exceptions.ReadPersonException;

import java.sql.*;
import java.util.List;

public class TestPersonDBService {


    public static void main(String[] args) throws SQLException {
        PersonDBService dbService = new PersonDBService();

        Person person = new Person();
        person.setName("test");
        person.setGender("M");
        person.setAge(18);
        person.setHeight(176);
        person.setWeight(65);

        dbService.create(person);

        Person person2 = new Person();

        person2.setName("test2");
        person2.setGender("F");
        person2.setAge(24);
        person2.setHeight(167);
        person2.setWeight(60);

        dbService.create(person2);


        List<Person> personsList = dbService.getAll();

        System.out.println(personsList);

        try {
            List<Person> personsListFromName = dbService.get("test");
        } catch (ReadPersonException e) {
            System.out.println("problem while reading the person data, please contact an admin");
            System.out.println("cause :" + e.getCause().getMessage());
        }

        System.out.println(personsList);

    }

}

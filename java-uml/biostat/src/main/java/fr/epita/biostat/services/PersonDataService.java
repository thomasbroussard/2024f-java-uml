package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.Person;

import java.util.List;

public class PersonDataService {


    public Double computeAverage(List<Person> personsList){
            return personsList.stream()
                // .mapToInt(p -> p.getAge())
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
    }
}

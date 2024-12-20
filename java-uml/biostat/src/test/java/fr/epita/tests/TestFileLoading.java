package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;
import fr.epita.biostat.services.PersonCSVService;
import fr.epita.biostat.services.PersonDataService;
import org.knowm.xchart.CategoryChart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TestFileLoading {

    public static void main(String[] args) throws IOException {
        PersonCSVService service = new PersonCSVService();
        PersonDataService personDataService = new PersonDataService();


        List<Person> persons = service.readPersons("./biostat/biostat.csv");
        double avg = personDataService.computeAverage(persons);


        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(groupingBy(Person::getAge));

        Map<Integer, List<Person>> personsByHeight = persons
                .stream()
                .collect(groupingBy(Person::getHeight));


        Map<String, List<Person>> personsByGender = persons
                .stream()
                .collect(groupingBy(Person::getGender));

        Map<String, Long> countOfpersonsByGender = persons
                .stream()
                .collect(groupingBy(Person::getGender, Collectors.counting()));


        System.out.println(personsByGender);
        System.out.println(countOfpersonsByGender);

        CategoryChart barChart = ChartUtils.getBarChart("Gender distribution", "gender", "count");
        List<String> genderKeys = new ArrayList<>(countOfpersonsByGender.keySet());
        List<Long> counts = new ArrayList<>(countOfpersonsByGender.values());
        barChart.addSeries("gender", genderKeys, counts);
        ChartUtils.displayChart(barChart);


        System.out.println(avg);

    }
}

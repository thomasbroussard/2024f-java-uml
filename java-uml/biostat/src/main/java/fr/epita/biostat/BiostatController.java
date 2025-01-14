package fr.epita.biostat;

import fr.epita.biostat.datamodel.Person;
import fr.epita.biostat.services.PersonDBService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BiostatController {

    private PersonDBService dbService = new PersonDBService();



    @GetMapping("")
    public ResponseEntity<List<Person>> testGet(@RequestParam("name") String name){
        try {
            return ResponseEntity.ok(dbService.get(name));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testPost(@RequestBody Person person){
        try {
            dbService.create(person);
        }catch (SQLException sqle){
            sqle.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok("created " + person.getName());
    }




}

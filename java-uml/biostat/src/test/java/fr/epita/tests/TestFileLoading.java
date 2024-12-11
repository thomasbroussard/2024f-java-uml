package fr.epita.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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


    }
}

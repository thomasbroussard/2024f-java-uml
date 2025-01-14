package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.Person;
import fr.epita.biostat.services.exceptions.ReadPersonException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDBService {

    public PersonDBService() {
        Connection connection =
                null;
        try {
            //TODO check alternatives here
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS  PERSONS(" +
                            "name varchar(255)," +
                            "gender varchar(255)," +
                            "age int," +
                            "height int," +
                            "weight int" +
                            ")"
            );

            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "test", "test");
    }

    public void create(Person person) throws SQLException {

        String sqlParamInsert =
                "INSERT INTO PERSONS(name, gender, age, height, weight)" +
                        " VALUES (?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement insertParamStatement = connection.prepareStatement(sqlParamInsert);
        insertParamStatement.setString(1, person.getName());
        insertParamStatement.setString(2, person.getGender());
        insertParamStatement.setInt(3, person.getAge());
        insertParamStatement.setInt(4, person.getHeight());
        insertParamStatement.setInt(5, person.getWeight());
        insertParamStatement.execute();
        connection.close();
    }

    public void update(Person person) {

    }

    public void delete(Person person) {

    }

    public List<Person> get(String name) throws ReadPersonException {
        List<Person> results = new ArrayList<>();
        String sqlSelect =
                "SELECT name, gender, age, height, weight FROM PERSONS WHERE name = ?";

        try (Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
            selectStatement.setString(1, name);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Person p = new Person();
                p.setName(resultSet.getString("name"));
                p.setGender(resultSet.getString("gender"));
                p.setAge(resultSet.getInt("age"));
                p.setHeight(resultSet.getInt("height"));
                p.setWeight(resultSet.getInt("weight"));
                results.add(p);
            }
        } catch (SQLException sqle) {
            ReadPersonException rpe = new ReadPersonException();
            rpe.initCause(sqle);
        }
        return results;

    }

    //TODO
    public List<Person> getAll() throws SQLException {

        String sqlSelect =
                "SELECT name, gender, age, height, weight FROM PERSONS";
        Connection connection = getConnection();
        PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
        ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("gender"));
            System.out.println(resultSet.getInt("age"));
            System.out.println(resultSet.getInt("height"));
            System.out.println(resultSet.getInt("weight"));
        }
        connection.close();
        return null;
    }
}

package fr.epita.tests;

import java.sql.*;

public class TestDatabaseConnection {


    public static void main(String[] args) throws SQLException {
        Connection connection =
                DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "CREATE TABLE PERSONS(" +
                        "name varchar(255)," +
                        "gender varchar(255)," +
                        "age int," +
                        "height int," +
                        "weight int" +
                        ")"
        );

        preparedStatement.execute();
        String sqlInsert =
                "INSERT INTO PERSONS(name, gender, age, height, weight)" +
                " VALUES ('test', 'M', 18, 176, 65)";
        PreparedStatement insertStatement = connection.prepareStatement(sqlInsert);
        insertStatement.execute();

        String sqlSelect =
                "SELECT * FROM PERSONS";
        PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
        ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }

        connection.close();

    }

}

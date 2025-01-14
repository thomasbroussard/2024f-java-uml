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

        String sqlParamInsert =
                "INSERT INTO PERSONS(name, gender, age, height, weight)" +
                " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement insertParamStatement = connection.prepareStatement(sqlParamInsert);
        insertParamStatement.setString(1, "test2");
        insertParamStatement.setString(2, "F");
        insertParamStatement.setInt(3, 24);
        insertParamStatement.setInt(4, 167);
        insertParamStatement.setInt(5, 60);
        insertParamStatement.execute();

        String sqlSelect =
                "SELECT name, gender, age, height, weight FROM PERSONS";
        PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
        ResultSet resultSet = selectStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("gender"));
            System.out.println(resultSet.getInt("age"));
            System.out.println(resultSet.getInt("height"));
            System.out.println(resultSet.getInt("weight"));
        }

        connection.close();

    }

}

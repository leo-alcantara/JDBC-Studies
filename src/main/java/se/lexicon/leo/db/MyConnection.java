package se.lexicon.leo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/library?&autoReconnect=true&SSLMode=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin";
    private static final String USER = "root";
    private static final String PASSWORD = "Noelle2018";

    private static final MyConnection instance = new MyConnection();

    private MyConnection(){}

    public static MyConnection getInstance(){
        return instance;
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
         connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return connection;
    }










}

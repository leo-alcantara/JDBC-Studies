package se.lexicon.leo;

import se.lexicon.leo.db.MyConnection;

import java.sql.*;

/**
 * Hello world!
 */
public class App {

    private static final String URL = "jdbc:mysql://localhost:3306/library?&autoReconnect=true&SSLMode=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin" ;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Noelle2018";

    public static void main(String[] args) {

        findAll();

        printOutMatchingAppUsers("Leo de Alcantara");
        printOutMatchingAppUsers("Sophie Odin");
        printOutMatchingAppUsers("Noelle Odin");
        printOutMatchingAppUsers("Philip Odin");


    }

    public static void printOutMatchingAppUsers(String username){
        String findByName ="SELECT*FROM app_user WHERE user_name = ?";

        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findByName);

            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println("Id: " + rs.getString(1));
                System.out.println("Username: " + rs.getString(2));
                System.out.println("Password: " + rs.getString(3));
                System.out.println("Membership Date: " + rs.getString(4));
                System.out.println("-----------------------------------------------");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }



    public static void findAll() {
        try {

            Connection connection = MyConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            String findAll = "SELECT*FROM books";

            ResultSet rs = statement.executeQuery(findAll);

            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString("book_title"));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println("----------------------------");
            }


        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }

}

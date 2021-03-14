package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.data.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args){
        Database database = Database.getInstance();

        ResultSet rs = database.query("SELECT * FROM employees");
        try {
            while (rs.next()){
                System.out.println("id = " + rs.getInt("id") + ", name = " + rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

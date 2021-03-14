package kz.aitu.oop.practice.assignment4.data;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;

import java.sql.*;
import java.util.Objects;


public class Database {
    private static Database instance;
    private static final IDB db = new PostgresDB();

    private Database(){

    }

    public static Database getInstance(){
        if (Database.instance == null) {
            Database.instance = new Database();
        }

        return Database.instance;
    }

    public ResultSet query(String sql) {
        Connection con = null;
        try {
            con = db.getConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


}

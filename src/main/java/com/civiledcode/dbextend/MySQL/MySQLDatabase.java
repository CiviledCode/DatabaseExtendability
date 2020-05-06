package com.civiledcode.dbextend.MySQL;

import com.civiledcode.dbextend.DBEMain;
import com.civiledcode.dbextend.Objects.DatabaseConnection;

import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public abstract class MySQLDatabase extends DatabaseConnection {
    String username, password, ip, databaseName;
    int port;

    public MySQLDatabase(String username, String password, String ip, String databaseName, int port) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.username = username;
            this.password = password;
            this.ip = ip;
            this.databaseName = databaseName;
            this.port = port;
        } catch (Exception e) {

        }
    }

    public boolean connect() {
        try {
            super.connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + databaseName, username, password);
            initiate();
            return true;
        } catch (SQLClientInfoException e) {
            DBEMain.log("The login information provided for the database " + databaseName + " is invalid!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean disconnect() {
        try {
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public abstract void initiate();
}

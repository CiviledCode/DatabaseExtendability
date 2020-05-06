package com.civiledcode.dbextend.SQLite;

import com.civiledcode.dbextend.Objects.DatabaseConnection;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteDatabase extends DatabaseConnection {
    File file;

    public SQLiteDatabase(File file) {
        this.file = file;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean connect() {
        try {
            super.connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
            initiate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

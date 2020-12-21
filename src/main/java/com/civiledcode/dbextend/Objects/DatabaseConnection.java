package com.civiledcode.dbextend.Objects;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    public Connection connection;

    public boolean executeUpdate(String update) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
            statement.close();
            return true;
        }
        return false;
    }

    public List<DatabaseEntry> executeQuery(String query) {
        List<DatabaseEntry> entries = new ArrayList<>();
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                ResultSetMetaData metadata = rs.getMetaData();
                int columnCount = metadata.getColumnCount();

                //Increment through all results and put all of the results into their own
                //DatabaseEntry.
                while (rs.next()) {
                    DatabaseEntry entry = new DatabaseEntry();
                    for (int i = 1; i <= columnCount; i++) {
                        entry.putValue(metadata.getColumnName(i), rs.getString(i));
                    }
                    entries.add(entry);
                }
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entries;
    }
}

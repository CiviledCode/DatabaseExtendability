package com.civiledcode.dbextend.Objects;

import java.util.HashMap;

public class DatabaseEntry {
    HashMap<String, String> valueMap = new HashMap<>();

    public void putValue(String name, String value) {
        valueMap.put(name, value);
    }

    public String getString(String name) {
        return valueMap.get(name);
    }

    public int getInt(String name) {
        try {
            return Integer.parseInt(valueMap.get(name));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double getDouble(String name) {
        try {
            return Double.parseDouble(valueMap.get(name));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

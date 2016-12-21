package com.testproject.testproject.core.preferences;

public interface LocalPreference {
    void saveData(String key, String value);

    void saveData(String key, Long value);

    void saveData(String key, Boolean value);

    void saveData(String key, int value);

    String getData(String key);

    Long getLongData(String key);

    Boolean getBooleanData(String key);

    int getIntData(String key);

    void removeData(String key);
}

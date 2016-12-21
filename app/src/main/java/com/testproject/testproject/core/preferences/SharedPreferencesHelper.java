package com.testproject.testproject.core.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import java.io.IOException;
public final class SharedPreferencesHelper implements LocalPreference {
    private final Context context;

    public SharedPreferencesHelper(Context context) {
        this.context = context;
    }

    @Override
    public void saveData(String key, String value) {
        SharedPreferences currentPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor currentEditor = currentPreferences.edit();
        currentEditor.putString(key, value);
        currentEditor.apply();

    }

    @Override
    public void saveData(String key, Long value) {
        SharedPreferences currentPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor currentEditor = currentPreferences.edit();
        currentEditor.putLong(key, value);
        currentEditor.apply();
    }

    @Override
    public void saveData(String key, Boolean value) {
        SharedPreferences currentPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor currentEditor = currentPreferences.edit();
        currentEditor.putBoolean(key, value);
        currentEditor.apply();
    }

    @Override
    public void saveData(String key, int value) {
        SharedPreferences currentPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor currentEditor = currentPreferences.edit();
        currentEditor.putInt(key, value);
        currentEditor.apply();
    }

    @Override
    public String getData(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    @Override
    public Long getLongData(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getLong(key, 0L);
    }

    @Override
    public Boolean getBooleanData(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);
    }

    @Override
    public int getIntData(String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getInt(key, 1);
    }

    @Override
    public void removeData(String key) {
        SharedPreferences currentPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor currentEditor = currentPreferences.edit();
        currentEditor.remove(key);
        currentEditor.apply();
    }


}

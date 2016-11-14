package com.app.seenit.seenit.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;

/**
 * Created by Isangi on 12/11/2016.
 */

public class SharedPreferencesManager {

    public static void saveData(Context con, String variable, String data)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(con);
        prefs.edit().putString(variable, data).commit();
    }

    public static String getData(Context con, String variable, String defaultValue)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(con);
        String data = prefs.getString(variable, defaultValue);
        return data;
    }


}

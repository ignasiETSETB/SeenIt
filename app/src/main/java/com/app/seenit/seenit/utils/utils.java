package com.app.seenit.seenit.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.EditText;

import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;
import com.app.seenit.seenit.com.app.seenit.seenit.activity.TitleScreen;
import com.google.gson.Gson;

/**
 * Created by Isangi on 9/11/2016.
 */

public class utils {

    public static String objectToJson(Object object){

        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

    public static Object stringToObject(String data, Object object){

        Gson gson = new Gson();
        Object objectToReturn = gson.fromJson(data, object.getClass());
        return objectToReturn;
    }
}

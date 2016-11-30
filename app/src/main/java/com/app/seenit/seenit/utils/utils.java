package com.app.seenit.seenit.utils;

import android.content.Context;

import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.com.app.seenit.seenit.activity.MainActivity;
import com.app.seenit.seenit.services.SharedPreferencesManager;
import com.google.gson.Gson;

/**
 * Created by Isangi on 9/11/2016.
 */

public class Utils {

    protected static Context context;
    protected static Utils instance=null;

    public static Utils getInstance(){
        if(instance==null)
            instance=new Utils();
        return instance;
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

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

    public static void saveData(){
        SeenItBean seenItBean=new SeenItBean();
        seenItBean=SeenItBean.getInstance();
        String saveData= Utils.objectToJson(seenItBean);
        SharedPreferencesManager.saveData(context,"seenItBean",saveData);
    }
}

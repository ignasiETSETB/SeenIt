package com.app.seenit.seenit.beans;

import java.util.ArrayList;

/**
 * Created by Isangi on 9/11/2016.
 */

public class SeenItBean {

    protected ArrayList<SerieBean> serieArray;

    protected static SeenItBean instance=null;

    public SeenItBean(){
        serieArray=new ArrayList<SerieBean>();
    }

    public static SeenItBean getInstance(){
        if(instance==null)
            instance=new SeenItBean();
        return instance;
    }

    public ArrayList<SerieBean> getSerieArray() {
        return serieArray;
    }

    public void setSerieArray(ArrayList<SerieBean> serieArray) {
        this.serieArray = serieArray;
    }

    public void addSerie(SerieBean serieBean){
        serieArray.add(serieBean);
    }

}

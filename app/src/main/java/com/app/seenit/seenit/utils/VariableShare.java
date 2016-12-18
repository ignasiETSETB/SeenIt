package com.app.seenit.seenit.utils;

import com.app.seenit.seenit.beans.SerieBean;

/**
 * Created by Isangi on 18/12/2016.
 */

public class VariableShare {

    public static VariableShare instance;
    protected int clickedItemOptions;
    protected SerieBean clickedEditSerie;

    public static VariableShare getInstance(){
        if(instance==null){
            instance=new VariableShare();
        }
        return instance;
    }

    public int getClickedItemOptions() {
        return clickedItemOptions;
    }

    public void setClickedItemOptions(int clickedItemOptions) {
        this.clickedItemOptions = clickedItemOptions;
    }

    public SerieBean getClickedEditSerie() {
        return clickedEditSerie;
    }

    public void setClickedEditSerie(SerieBean clickedEditSerie) {
        this.clickedEditSerie = clickedEditSerie;
    }
}

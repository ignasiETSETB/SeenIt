package com.app.seenit.seenit.beans;

import java.util.ArrayList;

/**
 * Created by Isangi on 9/11/2016.
 */

public class SerieBean {

    protected String title;
    protected ArrayList<SeasonBean> seasons;
    protected int numberOfSeries;
    protected int currentSerieNumber;

    public int getNumberOfSeries() {
        return numberOfSeries;
    }

    public void setNumberOfSeries(int numberOfSeries) {
        this.numberOfSeries = numberOfSeries;
    }

    public int getCurrentSerieNumber() {
        return currentSerieNumber;
    }

    public void setCurrentSerieNumber(int currentSerieNumber) {
        this.currentSerieNumber = currentSerieNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SeasonBean> getSeasons() {
        return seasons;
    }

    public void setSeasons(ArrayList<SeasonBean> seasons) {
        this.seasons = seasons;
    }
}

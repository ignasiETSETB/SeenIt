package com.app.seenit.seenit.beans;

import java.util.ArrayList;

/**
 * Created by Isangi on 9/11/2016.
 */

public class SeasonBean {

    protected ArrayList<ChapterBean> SeasonChapters;
    protected String seasonTitle;
    protected Integer numberOfSeasons;
    protected Integer currentSeasonNumber;

    public Integer getCurrentSeasonNumber() {
        return currentSeasonNumber;
    }

    public void setCurrentSeasonNumber(Integer currentSeasonNumber) {
        this.currentSeasonNumber = currentSeasonNumber;
    }

    public String getSeasonTitle() {
        return seasonTitle;
    }

    public void setSeasonTitle(String seasonTitle) {
        this.seasonTitle = seasonTitle;
    }

    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(Integer numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public ArrayList<ChapterBean> getSeasonChapters() {
        return SeasonChapters;
    }

    public void setSeasonChapters(ArrayList<ChapterBean> seasonChapters) {
        this.SeasonChapters = seasonChapters;
    }
}

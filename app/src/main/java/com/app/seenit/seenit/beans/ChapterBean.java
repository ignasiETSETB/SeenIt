package com.app.seenit.seenit.beans;

/**
 * Created by Isangi on 9/11/2016.
 */

public class ChapterBean {

    protected int numberOfChapters;
    protected String chapterTitle;
    protected Integer currentChapterNumber;
    protected Boolean chapterSeen;

    public Boolean getChapterSeen() {
        return chapterSeen;
    }

    public void setChapterSeen(Boolean chapterSeen) {
        this.chapterSeen = chapterSeen;
    }

    public Integer getCurrentChapterNumber() {
        return currentChapterNumber;
    }

    public void setCurrentChapterNumber(Integer currentChapterNumber) {
        this.currentChapterNumber = currentChapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public int getNumberOfChapters() {
        return numberOfChapters;
    }

    public void setNumberOfChapters(int numberOfChapters) {
        this.numberOfChapters = numberOfChapters;
    }
}

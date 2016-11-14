package com.app.seenit.seenit.com.app.seenit.seenit.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.app.seenit.seenit.R;
import com.app.seenit.seenit.beans.ChapterBean;
import com.app.seenit.seenit.beans.SeasonBean;
import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;
import com.app.seenit.seenit.services.SharedPreferencesManager;
import com.app.seenit.seenit.utils.utils;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by Isangi on 9/11/2016.
 */

public class AddSerie extends AppCompatActivity {

    private NumberPicker seasonNp, chapterNp;
    private EditText titleSerie;
    private Button addSerieBtn;
    private Integer numberOfChapters, numberOfSeasons,numberOfSeries;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_serie);

        final Context context=this;

        seasonNp=(NumberPicker) findViewById(R.id.seasonNumberPicker);
        chapterNp=(NumberPicker) findViewById(R.id.chapterNumberPicker);
        titleSerie=(EditText) findViewById(R.id.editTextSerieName);
        addSerieBtn=(Button) findViewById(R.id.buttonAddSerie);

        seasonNp.setMaxValue(50);
        seasonNp.setMinValue(1);
        chapterNp.setMaxValue(250);
        chapterNp.setMinValue(1);

        addSerieBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String chapterAdder="";
                ArrayList<SeasonBean> seasonArray=new ArrayList<SeasonBean>();


                numberOfChapters=chapterNp.getValue();
                numberOfSeasons=seasonNp.getValue();
                numberOfSeries=SeenItBean.getInstance().getSerieArray().size();

                if(numberOfChapters<100){
                    chapterAdder="x0";
                }else{
                    chapterAdder="x00";
                }

                for(int j=0; j<numberOfSeasons;j++) {

                    ArrayList<ChapterBean> chapterArray=new ArrayList<ChapterBean>();

                    SeasonBean seasonBean= new SeasonBean();
                    seasonBean.setNumberOfSeasons(numberOfSeasons);
                    seasonBean.setSeasonTitle("Season "+(j+1));

                    for (int i = 0; i < numberOfChapters; i++) {
                        ChapterBean chapterBean = new ChapterBean();
                        chapterBean.setNumberOfChapters(numberOfChapters);
                        chapterBean.setCurrentChapterNumber(i+1);
                        chapterBean.setChapterTitle((j+1)+chapterAdder+(i+1));
                        chapterArray.add(chapterBean);
                    }
                    seasonBean.setNumberOfSeasons(numberOfSeasons);
                    seasonBean.setCurrentSeasonNumber(j+1);
                    seasonBean.setSeasonChapters(chapterArray);
                    seasonArray.add(seasonBean);
                }

                SerieBean serieBean=new SerieBean();
                serieBean.setCurrentSerieNumber(numberOfSeries+1);
                serieBean.setTitle(titleSerie.getText().toString());
                serieBean.setSeasons(seasonArray);


                SeenItBean.getInstance().addSerie(serieBean);
                SeenItBean seenItBean=SeenItBean.getInstance();
                String saveData= utils.objectToJson(seenItBean);
                SharedPreferencesManager.saveData(context,"seenItBean",saveData);
                returnToTitle();
            }
        });
    }


    protected void returnToTitle(){
        Intent intent =new Intent(this,TitleScreen.class);
        startActivity(intent);
    }



}

package com.app.seenit.seenit.com.app.seenit.seenit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.app.seenit.seenit.R;
import com.app.seenit.seenit.beans.ChapterBean;
import com.app.seenit.seenit.beans.SeasonBean;
import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;

import java.util.ArrayList;

/**
 * Created by Isangi on 9/11/2016.
 */

public class ChapterScreen extends AppCompatActivity {

    private ListView listOfChapters;
    private SerieBean serieBean;
    private SeasonBean seasonBean;
    private ArrayList<String> chapterTitleArray=new ArrayList<>();
    private ArrayAdapter<String> chapterTitleArrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_screen);
        listOfChapters=(ListView) findViewById(R.id.chapterlist);

        Intent intent=getIntent();
        String seasonSelected=intent.getStringExtra("selected_season_name");
        String titleSerie=intent.getStringExtra("selected_serie_name");

        for(SerieBean searchSerieBean: SeenItBean.getInstance().getSerieArray()){
            if (searchSerieBean.getTitle().equals(titleSerie)) {
                serieBean=searchSerieBean;
                for(SeasonBean searchSeasonBean: serieBean.getSeasons()){
                    if(searchSeasonBean.getSeasonTitle().equals(seasonSelected)){
                        seasonBean=searchSeasonBean;
                    }
                }
            }
        }

        for(ChapterBean chapterTitle: seasonBean.getSeasonChapters()){
            chapterTitleArray.add(chapterTitle.getChapterTitle());
        }

        chapterTitleArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, chapterTitleArray);
        listOfChapters.setAdapter(chapterTitleArrayAdapter);

        listOfChapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String chapterClickedTitle=((TextView)view).getText().toString();


            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

}

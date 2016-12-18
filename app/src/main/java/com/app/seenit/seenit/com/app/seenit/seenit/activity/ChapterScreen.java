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
import android.widget.Toast;

import com.app.seenit.seenit.R;
import com.app.seenit.seenit.adapters.ChapterAdapter;
import com.app.seenit.seenit.adapters.DialogView;
import com.app.seenit.seenit.beans.ChapterBean;
import com.app.seenit.seenit.beans.SeasonBean;
import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;
import com.app.seenit.seenit.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Isangi on 9/11/2016.
 */

public class ChapterScreen extends AppCompatActivity {

    private ListView listOfChapters;
    private SerieBean serieBean;
    private SeasonBean seasonBean;
    private ArrayList<String> chapterTitleArray=new ArrayList<>();
    private ChapterAdapter chapterAdapter;
    private ArrayList<ChapterBean> chapterBeanArray;

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
                        chapterBeanArray =searchSeasonBean.getSeasonChapters();
                    }
                }
            }
        }

        for(ChapterBean chapterTitle: seasonBean.getSeasonChapters()){
            chapterTitleArray.add(chapterTitle.getChapterTitle());
        }

        chapterAdapter=new ChapterAdapter(ChapterScreen.this, R.layout.chapter_list_adapter, chapterBeanArray.toArray(new ChapterBean[chapterBeanArray.size()]));
        listOfChapters.setAdapter(chapterAdapter);

        listOfChapters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ChapterBean clickedChapter=(ChapterBean) listOfChapters.getItemAtPosition(i);
                if(clickedChapter.getChapterSeen()==true){
                    clickedChapter.setChapterSeen(false);
                    view.setSelected(false);
                    System.out.println("Chapter "+clickedChapter.getChapterTitle()+" marked as "+clickedChapter.getChapterSeen());

                }else{
                    clickedChapter.setChapterSeen(true);
                    view.setSelected(true);
                    System.out.println("Chapter "+clickedChapter.getChapterTitle()+" marked as "+clickedChapter.getChapterSeen());
                }
                chapterAdapter.notifyDataSetChanged();
                Utils.saveData();
            }
        });



      }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

}

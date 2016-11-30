package com.app.seenit.seenit.com.app.seenit.seenit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.app.seenit.seenit.R;
import com.app.seenit.seenit.beans.SeasonBean;
import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;

import java.util.ArrayList;

/**
 * Created by Isangi on 9/11/2016.
 */

public class SeasonScreen extends AppCompatActivity {


    private ListView listOfSeasons;
    private SerieBean serieBean;
    private ArrayList<String> seasonTitleArray=new ArrayList<>();
    private ArrayAdapter<String> seasonTitleArrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        final String titleSerie=intent.getStringExtra("selected_serie_name");

        setContentView(R.layout.activity_season_screen);

        listOfSeasons=(ListView) findViewById(R.id.seasonlist);

        for(SerieBean searchSerieBean: SeenItBean.getInstance().getSerieArray()){
            if (searchSerieBean.getTitle().equals(titleSerie)) {
                serieBean=searchSerieBean;
            }
        }
        for(SeasonBean seasontitle: serieBean.getSeasons()){
            seasonTitleArray.add(seasontitle.getSeasonTitle());
        }
        seasonTitleArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, seasonTitleArray);
        listOfSeasons.setAdapter(seasonTitleArrayAdapter);

        listOfSeasons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent= new Intent(getApplicationContext(), ChapterScreen.class);
                intent.putExtra("selected_season_name", ((TextView)view).getText().toString());
                intent.putExtra("selected_serie_name", titleSerie);
                startActivity(intent);

            }
        });



    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_add_serie:
                //go to add serie
                Intent intent=new Intent(this, AddSerie.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}


package com.app.seenit.seenit.com.app.seenit.seenit.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.app.seenit.seenit.R;
import com.app.seenit.seenit.adapters.DialogView;
import com.app.seenit.seenit.adapters.SerieAdapter;
import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;
import com.app.seenit.seenit.services.SharedPreferencesManager;
import com.app.seenit.seenit.utils.Utils;
import com.app.seenit.seenit.utils.VariableShare;

import java.util.ArrayList;

public class TitleScreen extends AppCompatActivity {

    private ListView titleListView;
    private static ArrayAdapter<String> serieTitleArrayAdapter;
    private static ArrayList<String> serieTitleArray =new ArrayList<>();
    private ArrayList<SerieBean> serieBeanArray;
    private SerieAdapter serieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        String savedData= SharedPreferencesManager.getData(this,"seenItBean",null);

        if(savedData!=null){
            SeenItBean seenItBean=new SeenItBean();
            seenItBean=(SeenItBean) Utils.stringToObject(savedData,seenItBean);
            SeenItBean.getInstance().setSerieArray(seenItBean.getSerieArray());
            Utils.getInstance().setContext(this.getApplicationContext());
        }else{
            Utils.getInstance().setContext(this.getApplicationContext());
        }
        serieBeanArray =SeenItBean.getInstance().getSerieArray();
        serieTitleArray.clear();
        for(SerieBean serieBean: serieBeanArray){
            serieTitleArray.add(serieBean.getTitle());
        }
        //serieTitleArrayAdapter.notifyDataSetChanged();
        titleListView=(ListView) findViewById(R.id.titleList);

        serieAdapter=new SerieAdapter(TitleScreen.this, R.layout.serie_list_adapter, serieBeanArray.toArray(new SerieBean[serieBeanArray.size()]));
        titleListView.setAdapter(serieAdapter);

        /*
        serieTitleArrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, serieTitleArray);
        titleListView.setAdapter(serieTitleArrayAdapter);
        */
        titleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                SerieBean clickedSerie=(SerieBean) titleListView.getItemAtPosition(i);
                Intent intent= new Intent(getApplicationContext(), SeasonScreen.class);
                intent.putExtra("selected_serie_name", clickedSerie.getTitle());
                startActivity(intent);

            }
        });

        titleListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                SerieBean longClickedChapter=(SerieBean) titleListView.getItemAtPosition(i);
                VariableShare.getInstance().setClickedEditSerie(longClickedChapter);
                VariableShare.getInstance().setClickedItemOptions(i);
                DialogView myDialog=new DialogView();
                myDialog.show(getSupportFragmentManager(),"my_dialog");

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
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

    public static void refreshAdapter(){
        serieTitleArray.clear();
        for(SerieBean serieBean: SeenItBean.getInstance().getSerieArray()){
            serieTitleArray.add(serieBean.getTitle());
        }
        serieTitleArrayAdapter.notifyDataSetChanged();
    }
}

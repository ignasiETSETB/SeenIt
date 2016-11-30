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
import com.app.seenit.seenit.beans.SeenItBean;
import com.app.seenit.seenit.beans.SerieBean;
import com.app.seenit.seenit.services.SharedPreferencesManager;
import com.app.seenit.seenit.utils.Utils;

import java.util.ArrayList;

public class TitleScreen extends AppCompatActivity {

    private ListView titleListView;
    private ArrayAdapter<String> serieTitleArrayAdapter;
    private ArrayList<String> serieTitleArray =new ArrayList<>();
    private ArrayList<SerieBean> seenItBeanArray;
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
        seenItBeanArray=SeenItBean.getInstance().getSerieArray();
        serieTitleArray.clear();
        for(SerieBean serieBean: seenItBeanArray){
            serieTitleArray.add(serieBean.getTitle());
        }
        //serieTitleArrayAdapter.notifyDataSetChanged();
        titleListView=(ListView) findViewById(R.id.titleList);
        serieTitleArrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, serieTitleArray);
        titleListView.setAdapter(serieTitleArrayAdapter);

        titleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent= new Intent(getApplicationContext(), SeasonScreen.class);
                String serieClickedTitle=((TextView)view).getText().toString();
                intent.putExtra("selected_serie_name", serieClickedTitle);
                startActivity(intent);

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
}

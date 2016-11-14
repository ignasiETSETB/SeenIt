package com.app.seenit.seenit.com.app.seenit.seenit.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;

import com.app.seenit.seenit.R;

/**
 * Created by Isangi on 9/11/2016.
 */

public class AddSeason extends AppCompatActivity {

    private Button addSeasonBtn;
    private NumberPicker numberOfSeasonsNp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSeasonBtn=(Button) findViewById(R.id.buttonAddSeason);
        numberOfSeasonsNp=(NumberPicker) findViewById(R.id.seasonNumberPicker);

        numberOfSeasonsNp.setMaxValue(50);
        numberOfSeasonsNp.setMinValue(1);

        addSeasonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
    }
}

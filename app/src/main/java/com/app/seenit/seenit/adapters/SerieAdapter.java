package com.app.seenit.seenit.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.app.seenit.seenit.R;
import com.app.seenit.seenit.beans.ChapterBean;
import com.app.seenit.seenit.beans.SerieBean;

import static android.content.ContentValues.TAG;

/**
 * Created by Isangi on 18/12/2016.
 */

public class SerieAdapter extends ArrayAdapter<SerieBean> {


    Context context;
    int layoutResourceId;
    SerieBean[] data=null;


    public SerieAdapter(Context context, int layoutResourceId, SerieBean[] data){
        super(context,layoutResourceId,data);
        this.layoutResourceId=layoutResourceId;
        this.context=context;
        this.data=data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Log.d(TAG, "getView: adapter position:" + position);
        View row=convertView;
        ChapterHolder holder = null;

        if(row==null){

            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(layoutResourceId,parent,false);

            holder=new ChapterHolder();

            holder.title=(TextView)row.findViewById(R.id.txtSerieTitleAdapter);
            holder.background=(TextView) row.findViewById(R.id.tvSerieBG);
            row.setTag(holder);
        }else{

            holder=(ChapterHolder)row.getTag();
        }

        SerieBean serieBean=data[position];

        holder.title.setText(serieBean.getTitle());

        return row;
    }



}

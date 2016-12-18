package com.app.seenit.seenit.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.seenit.seenit.R;
import com.app.seenit.seenit.beans.ChapterBean;

import static android.content.ContentValues.TAG;

/**
 * Created by Isangi on 30/11/2016.
 */

public class ChapterAdapter extends ArrayAdapter<ChapterBean> {

    Context context;
    int layoutResourceId;
    ChapterBean[] data=null;


    public ChapterAdapter(Context context, int layoutResourceId, ChapterBean[] data){
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

            holder.title=(TextView)row.findViewById(R.id.txtChapterTitleAdapter);
            holder.background=(TextView) row.findViewById(R.id.tvChapterBG);
            row.setTag(holder);
        }else{

            holder=(ChapterHolder)row.getTag();
        }

        ChapterBean chapterBean=data[position];

        holder.title.setText(chapterBean.getChapterTitle());

        if(chapterBean.getChapterSeen()==true){
            holder.background.setBackground(this.getContext().getDrawable(R.drawable.round_seen));
        }else{
            holder.background.setBackground(this.getContext().getDrawable(R.drawable.round));

        }

        return row;
    }

}

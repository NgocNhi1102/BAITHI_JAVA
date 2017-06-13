package com.phamduyvu.apptracnghiem.cauhoi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.phamduyvu.apptracnghiem.R;

/**
 * Created by T-420 on 29/05/2017.
 */

public class cauhoi_Adapter extends CursorAdapter {

    public cauhoi_Adapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view= LayoutInflater.from(context).inflate(R.layout.item_list_question, parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtch = (TextView)view.findViewById(R.id.txtCH);
        LinearLayout linQues = (LinearLayout)view.findViewById(R.id.linQues);

        if(cursor.getPosition()%2 == 0){
            linQues.setBackgroundColor(Color.parseColor("#FFE2DFDF"));
        }else linQues.setBackgroundColor(Color.parseColor("#ffffff"));

        txtch.setText(cursor.getString(1));
    }
}

package com.phamduyvu.apptracnghiem.diemso;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.phamduyvu.apptracnghiem.R;

/**
 * Created by T-420 on 29/05/2017.
 */

public class diem_Adapter extends CursorAdapter{

    public diem_Adapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final View view= LayoutInflater.from(context).inflate(R.layout.item_list_score, parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtten = (TextView)view.findViewById(R.id.txtTenP);
        TextView txtdiem = (TextView)view.findViewById(R.id.txtDiem);

        txtten.setText(cursor.getString(1));
        txtdiem.setText(cursor.getInt(2)+"");
    }
}

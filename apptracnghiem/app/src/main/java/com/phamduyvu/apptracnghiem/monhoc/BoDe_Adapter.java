package com.phamduyvu.apptracnghiem.monhoc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamduyvu.apptracnghiem.R;

import java.util.ArrayList;

/**
 * Created by T-420 on 28/05/2017.
 */

public class BoDe_Adapter extends ArrayAdapter<BoDe> {

    public BoDe_Adapter(Context context, ArrayList<BoDe> bode) {
        super(context, 0, bode);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
        }

        TextView txtten = (TextView)convertView.findViewById(R.id.txtTenDe);
        ImageView imgicon = (ImageView)convertView.findViewById(R.id.imgIcon);

        BoDe p = getItem(position);
        if(p != null){
            txtten.setText("" + p.getTen());
            imgicon.setImageResource(R.drawable.subject);
        }

        return convertView;
    }
}

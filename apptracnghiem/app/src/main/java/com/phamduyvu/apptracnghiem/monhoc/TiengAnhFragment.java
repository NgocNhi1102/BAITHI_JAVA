package com.phamduyvu.apptracnghiem.monhoc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.phamduyvu.apptracnghiem.MainActivity;
import com.phamduyvu.apptracnghiem.R;
import com.phamduyvu.apptracnghiem.slide.ScreenSlideActivity;

import java.util.ArrayList;


public class TiengAnhFragment extends Fragment {

    BoDe_Adapter bode_adapter;
    GridView gvbode;
    ArrayList<BoDe> arr_bode = new ArrayList<BoDe>();

    public TiengAnhFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Tiếng Anh");
        return inflater.inflate(R.layout.fragment_tieng_anh, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvbode = (GridView)getActivity().findViewById(R.id.gvBoDe);
        arr_bode.add(new BoDe("Đề số 1"));

        bode_adapter = new BoDe_Adapter(getActivity(), arr_bode);
        gvbode.setAdapter(bode_adapter);
        gvbode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("sode", i+1);
                intent.putExtra("monhoc", "tienganh");
                intent.putExtra("test","yes");
                startActivity(intent);
            }
        });
    }
}

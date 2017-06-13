package com.phamduyvu.apptracnghiem.monhoc;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.phamduyvu.apptracnghiem.MainActivity;
import com.phamduyvu.apptracnghiem.R;
import com.phamduyvu.apptracnghiem.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToanFragment extends Fragment {

    BoDe_Adapter bode_adapter;
    GridView gvbode;
    ArrayList<BoDe> arr_bode = new ArrayList<BoDe>();

    public ToanFragment() {
        // Required empty public constructor
    }


    @Override
    // làm việc với View
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Môn Toán");
        return inflater.inflate(R.layout.fragment_toan, container, false);
    }

    @Override
    // viết lệnh trên Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gvbode = (GridView)getActivity().findViewById(R.id.gvBoDe);

        // gán giá trị vào mảng
        arr_bode.add(new BoDe("Đề số 1"));
        //arr_bode.add(new BoDe("Đề số 2"));

        bode_adapter = new BoDe_Adapter(getActivity(), arr_bode);
        gvbode.setAdapter(bode_adapter);
        gvbode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                // lệnh chuyển màn hình (Activity)
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                // giá trị truyền
                intent.putExtra("sode", i+1);
                intent.putExtra("monhoc", "toan");
                intent.putExtra("test","yes");
                startActivity(intent);
            }
        });
    }
}

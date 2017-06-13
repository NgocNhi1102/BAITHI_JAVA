package com.phamduyvu.apptracnghiem.diemso;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.phamduyvu.apptracnghiem.MainActivity;
import com.phamduyvu.apptracnghiem.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiemFragment extends Fragment {

    ListView lvdiem;
    diemso_controller diemso_controller;
    diem_Adapter diem_adapter;

    public DiemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Danh sách điểm");
        return inflater.inflate(R.layout.fragment_diem, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        diemso_controller = new diemso_controller(getActivity());
        lvdiem = (ListView)getActivity().findViewById(R.id.lvDiem);
        Cursor cursor = diemso_controller.getDiem();
        diem_adapter = new diem_Adapter(getActivity(),cursor,true);
        lvdiem.setAdapter(diem_adapter);
    }
}

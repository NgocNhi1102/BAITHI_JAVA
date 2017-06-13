package com.phamduyvu.apptracnghiem.cauhoi;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.phamduyvu.apptracnghiem.MainActivity;
import com.phamduyvu.apptracnghiem.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimKiemFragment extends Fragment {

    ListView lvch;
    cauhoi_Adapter cauhoi_adapter;
    cauhoi_controller cauhoi_controller;
    EditText edittimkiem;
    ImageButton imgmonhoc;
    String monhoc = "";
    public TimKiemFragment() {
        // Required empty public constructor
    }


    public  void begin(){
        lvch = (ListView)getActivity().findViewById(R.id.lvCH);
        edittimkiem = (EditText)getActivity().findViewById(R.id.editTimKiem);
        cauhoi_controller = new cauhoi_controller(getActivity());
        imgmonhoc = (ImageButton)getActivity().findViewById(R.id.imgMonHoc);
        listCursors(cauhoi_controller.getTKCauHoi(monhoc, edittimkiem.getText().toString()));
    }

    public  void listCursors(Cursor cursor){
        cauhoi_adapter = new cauhoi_Adapter(getActivity(),cursor, true);
        lvch.setAdapter(cauhoi_adapter);
        cauhoi_adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Tìm Kiếm");
        return inflater.inflate(R.layout.fragment_tim_kiem, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        begin();

        edittimkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listCursors(cauhoi_controller.getTKCauHoi(monhoc, edittimkiem.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imgmonhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
    }

    // hiển thị danh sách môn học tìm kiếm
    public  void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.questall:
                        monhoc = "";
                        listCursors(cauhoi_controller.getTKMonHOc(monhoc));
                        break;
                    case R.id.toan:
                        monhoc = "toan";
                        listCursors(cauhoi_controller.getTKMonHOc(monhoc));
                        break;
                    case R.id.tienganh:
                        monhoc = "tienganh";
                        listCursors(cauhoi_controller.getTKMonHOc(monhoc));
                        break;
                }
                return false;
            }
        });
        popupMenu.inflate(R.menu.menu_question);
        setForceShowIcon(popupMenu);
        popupMenu.show();
    }

    //Hiện thị icon trên popupMenu Field
    //import java.lang.reflect.Field;
    //import java.lang.reflect.Method;
    public static void setForceShowIcon(PopupMenu popupMenu) {
        try {
            Field[] fields = popupMenu.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper
                            .getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod(
                            "setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

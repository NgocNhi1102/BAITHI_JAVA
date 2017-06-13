package com.phamduyvu.apptracnghiem.diemso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.phamduyvu.apptracnghiem.cauhoi.DBHelper;
import com.phamduyvu.apptracnghiem.cauhoi.cauhoi;

import java.util.ArrayList;

/**
 * Created by T-420 on 29/05/2017.
 */

public class diemso_controller {
    private DBHelper dbHelper;

    public diemso_controller(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void Insert_diem(String ten, int diem) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //gói nhiều giá trị cùng lúc để lưu
        ContentValues values = new ContentValues();
        values.put("ten", ten);
        values.put("diemso", diem);
        db.insert("diem", null, values);
        db.close();
    }


    //lấy danh sách điểm
    public Cursor getDiem() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("diem", //tên bảng
                null,           //Danh sách cột cần lấy
                null,           //điều kiện Where
                null,           //đối số điều kiện Where
                null,           //biểu thức Groupby
                null,           //biểu thức Having
                "_id DESC",     //biểu thức Order By
                null
        );
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return  cursor;
    }
}

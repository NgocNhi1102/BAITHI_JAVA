package com.phamduyvu.apptracnghiem.slide;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.phamduyvu.apptracnghiem.R;
import com.phamduyvu.apptracnghiem.cauhoi.cauhoi;
import com.phamduyvu.apptracnghiem.diemso.diemso_controller;
import com.phamduyvu.apptracnghiem.monhoc.HomeFragment;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<cauhoi> arr_cauhoiBD = new ArrayList<cauhoi>();
    int traloi_dung = 0;
    int traloi_sai = 0;
    int traloi_khong = 0;
    int tongdiem = 0;

    diemso_controller diemso_controller;

    TextView txtcaudung, txtcausai, txtcauchuatl, txttongdiem;
    Button btnluudiem, btnlamlai, btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

        diemso_controller = new diemso_controller(TestDoneActivity.this);

        // lấy list câu hỏi
        final Intent intent = getIntent();
        arr_cauhoiBD = (ArrayList<cauhoi>) intent.getExtras().getSerializable("arr_cauhoi");

        txtcauchuatl = (TextView) findViewById(R.id.txtCauChuaTL);
        txtcausai = (TextView) findViewById(R.id.txtCauSai);
        txtcaudung = (TextView) findViewById(R.id.txtCauDung);
        txttongdiem = (TextView) findViewById(R.id.txtTongDiem);
        btnlamlai = (Button) findViewById(R.id.btnLamLai);
        btnluudiem = (Button) findViewById(R.id.btnLuuDiem);
        btnthoat = (Button) findViewById(R.id.btnThoat);


        ktra_ketqua();
        tongdiem = traloi_dung * 10;
        txtcauchuatl.setText("" + traloi_khong);
        txtcaudung.setText("" + traloi_dung);
        txtcausai.setText("" + traloi_sai);
        txttongdiem.setText("" + tongdiem);

        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        btnluudiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater = TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.alert_dialog_save_score, null);
                builder.setView(view);

                final EditText editten = (EditText) view.findViewById(R.id.editTen);
                TextView txtdiemso = (TextView) view.findViewById(R.id.txtDiemSo);
                int diemtong = traloi_dung * 10;
                txtdiemso.setText(diemtong + " điểm");


                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ten = editten.getText().toString();
                        diemso_controller.Insert_diem(ten, tongdiem);
                        Toast.makeText(TestDoneActivity.this, "Lưu điểm thành công", Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog b = builder.create();
                b.show();
            }
        });

        btnlamlai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                HomeFragment homeFragment = new HomeFragment();
//                FragmentManager manager = getSupportFragmentManager();
//                manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();
                refresh();
                finish();
                Intent intent2 = new Intent(TestDoneActivity.this, ScreenSlideActivity.class);
                intent2.putExtra("arr_cauhoi", arr_cauhoiBD);
                intent2.putExtra("test","no");
                startActivity(intent2);
            }
        });
    }

    // làm mới mảng câu hỏi
    public void  refresh(){
        for(int i = 0; i < arr_cauhoiBD.size(); i++){
            arr_cauhoiBD.get(i).setTraloi("");
        }
    }


    //hàm check kết quả
    public void ktra_ketqua() {
        for (int i = 0; i < arr_cauhoiBD.size(); i++) {
            if (arr_cauhoiBD.get(i).getTraloi().equals("") == true) {
                traloi_khong++;
            } else if (arr_cauhoiBD.get(i).getDapan().equals(arr_cauhoiBD.get(i).getTraloi()) == true) {
                traloi_dung++;
            } else
                traloi_sai++;
        }
    }
}

package com.example.da3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.da3.Object.CauHoi;
import com.example.da3.Sql.Database;

import java.util.ArrayList;

public class QLkiemtra extends AppCompatActivity {
    TextView tv_cauhoiso, tv_noidung, tv_diem, tv_thoigian;
    Button bt_DapanA, bt_DapanB, bt_DapanC, bt_DapanD;
    ImageView img_quaylai;
    CountDownTimer countDownTimer;
    Database database = new Database(this);
    ArrayList<CauHoi> listcauhoi = new ArrayList<>();
    CauHoi cauhoi = new CauHoi();
    Animation load,mdiem;
    int vitri = 0;
    int diem = 0;
    int time = 20;
    MediaPlayer dapandung, dapansai, demnguoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiemtra);
        anhxa();
        listcauhoi = database.getAll();
        cauhoi = listcauhoi.get(vitri);
        setAlldata(cauhoi);
        mdiem= AnimationUtils.loadAnimation(this,R.anim.zoom);
        dapandung = MediaPlayer.create(this, R.raw.dung);
        dapansai = MediaPlayer.create(this, R.raw.sai);
        demnguoc = MediaPlayer.create(this,R.raw.demnguoc);
        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = time-1;
                tv_thoigian.setText("Time: " + time);

            }

            @Override
            public void onFinish() {
                Toast.makeText(QLkiemtra.this,"Đã hết thời gian", Toast.LENGTH_LONG).show();
                dialogketthuc();

            }
        }.start();
        img_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLkiemtra.this, menu.class));

            }
        });


    }

    public void anhxa() {
        img_quaylai = findViewById(R.id.img_quaylaikt);
        tv_noidung = findViewById(R.id.tv_contentquestionkt);
        bt_DapanA = findViewById(R.id.tv_dapan1kt);
        bt_DapanB = findViewById(R.id.tv_dapan2kt);
        bt_DapanC = findViewById(R.id.tv_dapan3kt);
        bt_DapanD = findViewById(R.id.tv_dapan4kt);
        tv_cauhoiso = findViewById(R.id.tv_questionkt);
        tv_diem = findViewById(R.id.diemso);
        tv_thoigian = findViewById(R.id.timekt);
    }

    public void setAlldata(CauHoi cauhoi) {
        tv_noidung.setText(cauhoi.getCauhoii());
        bt_DapanA.setText(cauhoi.getDapanA());
        bt_DapanB.setText(cauhoi.getDapanB());
        bt_DapanC.setText(cauhoi.getDapanC());
        bt_DapanD.setText(cauhoi.getDapanD());
        int a = vitri + 1;
        tv_cauhoiso.setText("Câu " + a);

    }

    public void chondung(Button button) {
        button.setBackgroundResource(R.drawable.bg_green_15);
        dapandung.start();



    }

    public void chonsai(Button button) {
        button.setBackgroundResource(R.drawable.bg_red_15);
        dapansai.start();

    }

    public void resetColor() {
        bt_DapanA.setBackgroundResource(R.drawable.bg_blue_15);
        bt_DapanB.setBackgroundResource(R.drawable.bg_blue_15);
        bt_DapanC.setBackgroundResource(R.drawable.bg_blue_15);
        bt_DapanD.setBackgroundResource(R.drawable.bg_blue_15);
    }


    public void ClickDapanAkt(View view) {
        bt_DapanA.setBackgroundResource(R.drawable.bg_orange_30);

        if (cauhoi.getDapanA().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanA);
                    tinhdiem();
                }
            }, 1000);

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chonsai(bt_DapanA);
                    hienDapandung();
                }
            }, 1000);

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                next();
            }
        }, 1500);
    }

    public void ClickDapanBkt(View view) {
        bt_DapanB.setBackgroundResource(R.drawable.bg_orange_30);
        if (cauhoi.getDapanB().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanB);
                    tinhdiem();


                }
            }, 1000);

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chonsai(bt_DapanB);
                    hienDapandung();
                }
            }, 1000);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        }, 1500);
    }

    public void ClickDapanCkt(View view) {
        bt_DapanC.setBackgroundResource(R.drawable.bg_orange_30);
        if (cauhoi.getDapanC().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanC);
                    tinhdiem();
                }
            }, 1000);

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chonsai(bt_DapanC);
                    hienDapandung();
                }
            }, 1000);

        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                next();
            }
        }, 1500);
    }

    public void ClickDapanDkt(View view) {
        bt_DapanD.setBackgroundResource(R.drawable.bg_orange_30);
        if (cauhoi.getDapanD().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanD);
                    tinhdiem();
                }
            }, 1000);


        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chonsai(bt_DapanD);
                    hienDapandung();
                }
            }, 1000);

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        }, 1500);
    }

    public void next() {
        resetColor();
        vitri++;
        time=20;
        countDownTimer.cancel();
        countDownTimer.start();
        loadAnim();
        cauhoi = listcauhoi.get(vitri);
        setAlldata(cauhoi);
        if (vitri == listcauhoi.size()-1) {
            Toast.makeText(this,"Bạn đã hoàn thành bài kiểm tra", Toast.LENGTH_LONG).show();
            dialoghet();
        }

    }

    public void hienDapandung() {
        if (cauhoi.getDapan().equals(cauhoi.getDapanA())) {
            bt_DapanA.setBackgroundResource(R.drawable.bg_green_15);
        } else if (cauhoi.getDapan().equals(cauhoi.getDapanB())) {
            bt_DapanB.setBackgroundResource(R.drawable.bg_green_15);
        } else if (cauhoi.getDapan().equals(cauhoi.getDapanC())) {
            bt_DapanC.setBackgroundResource(R.drawable.bg_green_15);
        } else if (cauhoi.getDapan().equals(cauhoi.getDapanD())) {
            bt_DapanD.setBackgroundResource(R.drawable.bg_green_15);
        }


    }
    public void tinhdiem(){
        diem = diem + 10;
        tv_diem.setText("Điểm: " + diem);
    }
    public void dialogketthuc(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.thua);
        Window window=dialog.getWindow();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button choilai=dialog.findViewById(R.id.btn_choilai);
        TextView diem1=dialog.findViewById(R.id.txdiemketthuc);
        diem1.setText(String.valueOf(diem));
        Button menuu=dialog.findViewById(R.id.btn_menuover);
        choilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLkiemtra.this, QLkiemtra.class));
            }
        });
        menuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLkiemtra.this, menu.class));
            }
        });
        dialog.show();
    }
    public void dialoghet(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.thang);
        Window window=dialog.getWindow();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button quaylai=dialog.findViewById(R.id.btn_quaylaimenu);
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLkiemtra.this, menu.class));
            }
        });
        dialog.show();
    }

    public void loadAnim() {
        load = AnimationUtils.loadAnimation(this, R.anim.load);
        bt_DapanA.startAnimation(load);
        bt_DapanB.startAnimation(load);
        bt_DapanC.startAnimation(load);
        bt_DapanD.startAnimation(load);
        tv_cauhoiso.startAnimation(load);
        tv_noidung.startAnimation(load);
        tv_thoigian.startAnimation(load);
        tv_diem.startAnimation(load);
        img_quaylai.startAnimation(load);
    }
}

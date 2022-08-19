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

public class QLluyentap extends AppCompatActivity {
    TextView tv_cauhoiso, tv_noidung, tv_diem, tv_thoigian;
    Button bt_DapanA, bt_DapanB, bt_DapanC, bt_DapanD;
    ImageView img_quaylai;
    CountDownTimer countDownTimer;
    Database database = new Database(this);
    ArrayList<CauHoi> listcauhoi = new ArrayList<>();
    CauHoi cauhoi = new CauHoi();
    Animation load,mdiem;
    int vitri = 0;
    int time = 20;
    MediaPlayer dapandung, dapansai, demnguoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.luyentap);
        anhxa();
        listcauhoi = database.getAll();
        cauhoi = listcauhoi.get(vitri);
        setAlldata(cauhoi);
        mdiem=AnimationUtils.loadAnimation(this,R.anim.zoom);
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
                Toast.makeText(QLluyentap.this,"Đã hết thời gian", Toast.LENGTH_LONG).show();
                dialogketthuclt();

            }
        }.start();
        img_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLluyentap.this, menu.class));

            }
        });


    }

    public void anhxa() {
        img_quaylai = findViewById(R.id.img_quaylailt);
        tv_noidung = findViewById(R.id.tv_contentquestionlt);
        bt_DapanA = findViewById(R.id.tv_dapan1lt);
        bt_DapanB = findViewById(R.id.tv_dapan2lt);
        bt_DapanC = findViewById(R.id.tv_dapan3lt);
        bt_DapanD = findViewById(R.id.tv_dapan4lt);
        tv_cauhoiso = findViewById(R.id.tv_questionlt);
        tv_diem = findViewById(R.id.diemso);
        tv_thoigian = findViewById(R.id.time);
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


    public void ClickDapanAlt(View view) {
        bt_DapanA.setBackgroundResource(R.drawable.bg_orange_30);
        countDownTimer.cancel();
        countDownTimer.start();
        if (cauhoi.getDapanA().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanA);
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

    public void ClickDapanBlt(View view) {
        bt_DapanB.setBackgroundResource(R.drawable.bg_orange_30);
        countDownTimer.cancel();
        countDownTimer.start();
        if (cauhoi.getDapanB().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanB);


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

    public void ClickDapanClt(View view) {
        bt_DapanC.setBackgroundResource(R.drawable.bg_orange_30);
        countDownTimer.cancel();
        countDownTimer.start();
        if (cauhoi.getDapanC().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanC);
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

    public void ClickDapanDlt(View view) {
        countDownTimer.cancel();
        countDownTimer.start();
        bt_DapanD.setBackgroundResource(R.drawable.bg_orange_30);
        if (cauhoi.getDapanD().equals(cauhoi.getDapan())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    chondung(bt_DapanD);
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
            Toast.makeText(this, "Bạn đã hoàn thành bài học", Toast.LENGTH_LONG).show();
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
    public void dialogketthuclt(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.hetgio);
        Window window=dialog.getWindow();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button choilai=dialog.findViewById(R.id.btn_choilailt);
        Button menuu=dialog.findViewById(R.id.btn_menuoverlt);
        choilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLluyentap.this, QLluyentap.class));
            }
        });
        menuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QLluyentap.this, menu.class));
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
                startActivity(new Intent(QLluyentap.this, menu.class));
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
        tv_diem.startAnimation(load);
        tv_thoigian.startAnimation(load);
    }
}



package com.example.da3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class menu extends AppCompatActivity {
    MediaPlayer mediaPlayer, demnguoc;
    Button bt_hocbai, bt_luyentap, bt_kiemtra;
    ImageView img_quaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        Media();
        anhxa();
        bt_hocbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, QLhocbai.class));
                mediaPlayer.pause();
            }
        });
        bt_luyentap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, QLluyentap.class));
                mediaPlayer.pause();

            }
        });

        img_quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, MainActivity.class));
                mediaPlayer.pause();
            }
        });
        bt_kiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(menu.this, QLkiemtra.class));
                mediaPlayer.pause();

            }
        });
    }

    private void Media() {
        mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        demnguoc = MediaPlayer.create(this, R.raw.demnguoc);
    }
    private void anhxa(){
        bt_hocbai = findViewById(R.id.hocbai);
        bt_luyentap = findViewById(R.id.btluyentap);
        bt_kiemtra = findViewById(R.id.kiemtra);
        img_quaylai = findViewById(R.id.quaylaimenu);
    }
}
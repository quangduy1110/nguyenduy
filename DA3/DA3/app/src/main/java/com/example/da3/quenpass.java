package com.example.da3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quenpass extends AppCompatActivity {
    TextView tvquaylai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quenpass);
        tvquaylai = findViewById(R.id.quaylai);
        tvquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(quenpass.this, MainActivity.class));
            }
        });
    }
}
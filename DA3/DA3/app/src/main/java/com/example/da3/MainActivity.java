package com.example.da3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvdangky, tvquenpass;
    Button btdangnhap;
    EditText edittaikhoan, editmatkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangnhap);
        anhxa();
        tvdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, dangky.class));
            }
        });
        tvquenpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, quenpass.class));
            }
        });
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickdangnhap();
            }
        });
    }

    private void clickdangnhap(){
        String strtaikhoan = edittaikhoan.getText().toString().trim();
        String strmatkhau = editmatkhau.getText().toString().trim();
        if (!(strtaikhoan.equals("") || strmatkhau.equals(""))){
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(strtaikhoan, strmatkhau)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent dangnhap = new Intent(getApplicationContext(),menu.class);
                                startActivity(dangnhap);
                                finishAffinity();
                            } else {
                                Toast.makeText(getApplicationContext(),"Đăng nhập thất bại",Toast.LENGTH_LONG).show();
                                edittaikhoan.setText("");
                                editmatkhau.setText("");
                            }
                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin tài khoản và mật khẩu",Toast.LENGTH_LONG).show();
            edittaikhoan.setText("");
            editmatkhau.setText("");
        }

    }


    private void anhxa() {
        tvdangky = findViewById(R.id.tv_taotaikhoan);
        tvquenpass = findViewById(R.id.tv_quenmk);
        btdangnhap = findViewById(R.id.bt_dangnhap);
        editmatkhau = findViewById(R.id.edt_matkhau);
        edittaikhoan = findViewById(R.id.edt_taikhoan);
    }
}

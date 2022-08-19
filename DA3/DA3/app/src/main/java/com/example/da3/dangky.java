package com.example.da3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class dangky extends AppCompatActivity {
    Button btthoat, bt_dangky;
    EditText edt_email, edt_matkhau, edt_nhaplaimk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);
        anhxa();
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dangky.this, MainActivity.class));
            }
        });
        bt_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickdangky();
            }
        });
    }

    private void clickdangky() {
        String strtaikhoan = edt_email.getText().toString().trim();
        String strmatkhau = edt_matkhau.getText().toString().trim();
        String strxacnhan = edt_nhaplaimk.getText().toString().trim();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if(!(strtaikhoan.equals("") || strmatkhau.equals("") || strxacnhan.equals(""))){
            if (strmatkhau.equals(strxacnhan)){
                auth.createUserWithEmailAndPassword(strtaikhoan, strmatkhau)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Intent dangky = new Intent(dangky.this,MainActivity.class);
                                    startActivity(dangky);
                                    finishAffinity();
                                } else {
                                    Toast.makeText(dangky.this,"Đăng ký thất bại",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }else {
                Toast.makeText(dangky.this,"Mật khẩu xác nhận không chính xác",Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(dangky.this,"Vui lòng nhập đầy đủ thông tin tài khoản và mật khẩu và mật khẩu xác nhận",Toast.LENGTH_LONG).show();
            edt_email.setText("");
            edt_matkhau.setText("");
            edt_nhaplaimk.setText("");
        }
    }


    public void anhxa(){
        bt_dangky = findViewById(R.id.bt_dangky);
        btthoat = findViewById(R.id.thoatdk);
        edt_email = findViewById(R.id.edt_email);
        edt_matkhau = findViewById(R.id.edt_matkhau);
        edt_nhaplaimk = findViewById(R.id.edt_nhaplaipass);

    }
}
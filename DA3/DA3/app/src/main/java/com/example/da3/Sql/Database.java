package com.example.da3.Sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.da3.Object.CauHoi;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public static String DBname="DTCauhoii";

    public Database(@Nullable Context context) {
        super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Cauhoi(Cauhoii text ,DapanA text,DapanB text,DapanC text,DapanD text,Dapan text)");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Hình tam giác là hình có:','2 cạnh','3 cạnh','5 cạnh','4 cạnh','3 cạnh')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Có bao nhiêu số có 1 chữ số','9','10','90','8','9')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Kết quả của phép tính 9 + 1 - 5 là:','7','9','6','5','5')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Số lớn nhất có hai chữ số là:','80','99','100','10','99')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Số mà có số liền trước là số 20 là:','18','19','21','22','19')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Dãy số nào là dãy số lớn nhất:','0;1;2;3;4','5;6;7;8;9','9;10;11;12','16;17;18;19','16;17;18;19')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Điền vào chỗ trống ... + 10 = 20:','15','10','20','30','10')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Số nào nhỏ nhất trong dãy số 49;29;39;59','29','39','49','59','29')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Số lớn hơn 62 và nhỏ hơn 64 là số:','63','60','59','65','63')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Một tuần có:','5 ngày','6 ngày','7 ngày','8 ngày','7 ngày')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Số bé nhất trong các số: 3, 0, 7, 6 là:','0','3','6','7','0')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Số lớn nhất trong các số: 6, 10, 7, 9 là:','9','6','7','10','10')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Kết quả phép tính: 9 – 3 + 1 =','5','7','9','3','7')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES (' Số cần điền tiếp vào dãy số 1;2;3;45, …., 9. là:','789','567','678','456','678')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Kết quả của 3 + 5 là:','5','3','7','8','8')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Sắp xếp các số: 0;5;2;10 theo thứ tự từ bé đến lớn:','10;5;2;0',' 2;0;10;5','0;2;5;10','5;2;0;10','0;2;5;10')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Dấu cần điền vào 4 ….2 = 6 là:','-','+','/','*','+')");
        db.execSQL("INSERT INTO Cauhoi (Cauhoii ,DapanA ,DapanB ,DapanC ,DapanD ,Dapan ) VALUES ('Số lớn nhất có một chữ số là:','8','10','9','7','9')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
    public ArrayList<CauHoi> getAll() {
        ArrayList<CauHoi> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String select = "select * from Cauhoi";
        Cursor cursor = db.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                CauHoi cauhoi = new CauHoi();
                cauhoi.setCauhoii(cursor.getString(0));
                cauhoi.setDapanA(cursor.getString(1));
                cauhoi.setDapanB(cursor.getString(2));
                cauhoi.setDapanC(cursor.getString(3));
                cauhoi.setDapanD(cursor.getString(4));
                cauhoi.setDapan(cursor.getString(5));
                list.add(cauhoi);
            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }
}


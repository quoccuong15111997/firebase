package com.example.firebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mData;
    TextView txtData;
    Button btnCuong,btnHuynh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("HoTen").setValue("Nguyễn Quốc Cường");



        SinhVien sinhVien1 = new SinhVien("Nguyễn Quốc Cường", "0977929100", 22);
        SinhVien sinhVien2 = new SinhVien("Nguyễn Trần Thúy Huỳnh", "0977929100", 23);
        SinhVien sinhVien3 = new SinhVien("Nguyễn Phương Ngân", "0977929100", 24);
        SinhVien sinhVien4 = new SinhVien("Nguyễn Văn Tèo", "0977929100", 25);
        SinhVien sinhVien5 = new SinhVien("Nguyễn Văn Heo", "0977929100", 26);
        SinhVien sinhVien6 = new SinhVien("Nguyễn Thị Mẹt", "0977929100", 27);

        /*mData.child("SinhVien").push().setValue(sinhVien1);
        mData.child("SinhVien").push().setValue(sinhVien2);
        mData.child("SinhVien").push().setValue(sinhVien3);
        mData.child("SinhVien").push().setValue(sinhVien4);
        mData.child("SinhVien").push().setValue(sinhVien5);
        mData.child("SinhVien").push().setValue(sinhVien6);*/

        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("XeMay", 2);
        myMap.put("OTo", 4);
        mData.child("PhuongTien").setValue(myMap);

        txtData = findViewById(R.id.txtData);
        btnCuong = findViewById(R.id.btnCuong);
        btnHuynh = findViewById(R.id.btnHuynh);

        mData.child("Phone").setValue("Iphone", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                /*if (databaseError == null) {
                    Toast.makeText(MainActivity.this,"Lưu thành công",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Lưu thất bại",Toast.LENGTH_LONG).show();*/
            }
        });
        mData.child("HoTen").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtData.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnCuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.child("HoTen").setValue("Nguyễn Quốc Cường");
            }
        });
        btnHuynh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.child("HoTen").setValue("Nguyễn Trần Thúy Huỳnh");
            }
        });

        /*PhuongTien tien= new PhuongTien("Xe Máy",2);
        PhuongTien tien1= new PhuongTien("Ô Tô",4);
        mData.child("PhuongTien").push().setValue(tien);
        mData.child("PhuongTien").push().setValue(tien1);*/

        /*mData.child("KhoaHoc").push().setValue("Lập trình Android");
        mData.child("KhoaHoc").push().setValue("Lập trình IOS");
        mData.child("KhoaHoc").push().setValue("Lập trình Windown Form");
        mData.child("KhoaHoc").push().setValue("Lập trình Web");
        mData.child("KhoaHoc").push().setValue("Lập trình Nhúng ");*/
        mData.child("KhoaHoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //Toast.makeText(MainActivity.this,dataSnapshot.getValue().toString()+"\n",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mData.child("PhuongTien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mData.child("SinhVien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SinhVien sinhVien = dataSnapshot.getValue(SinhVien.class);
                Toast.makeText(MainActivity.this, sinhVien.getTen(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

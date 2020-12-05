package com.example.tubesprobmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class addSchedule extends AppCompatActivity {
Button button;
EditText addjudul, addjam, adddosen, addlink, addkode;
TextInputLayout txtjudul, txtjam, txtdosen, txtlink, txtkode;
RoomDB database;
MainAdapter adapter;
List<MainData> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        txtjudul = findViewById(R.id.txtaddjudul);
        txtjam = findViewById(R.id.txtaddjam);
        txtdosen = findViewById(R.id.txtadddosen);
        txtlink = findViewById(R.id.txtaddlink);
        txtkode = findViewById(R.id.txtaddkode);

        addjudul = findViewById(R.id.judulMatkul);
        addjam = findViewById(R.id.hariDanJam);
        adddosen = findViewById(R.id.dosen);
        addlink = findViewById(R.id.link);
        addkode = findViewById(R.id.kodeMatkul);
        database = RoomDB.getInstance(this);
        button = findViewById(R.id.saveData);
        saveData();
    }

    private void saveData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                String sjudul = addjudul.getText().toString().trim();
                String sjam = addjam.getText().toString().trim();
                String sdosen = adddosen.getText().toString().trim();
                String slink = addlink.getText().toString().trim();
                String skode = addkode.getText().toString().trim();
                MainData data = new MainData();
                data.setJudulMatkul(sjudul);
                data.setHariJam(sjam);
                data.setDosen(sdosen);
                data.setLink(slink);
                data.setKodeMatkul(skode);
                database.mainDao().insert(data);
                addjudul.setText("");
                addjam.setText("");
                adddosen.setText("");
                addlink.setText("");
                addkode.setText("");
                Intent i = new Intent(addSchedule.this, MainActivity.class);
                String success = "success";
                i.putExtra("suc", success);
                startActivity(i);
            }
            }
        });
    }

    private boolean validate() {
        if(addjudul.getText().toString().isEmpty()){
            txtjudul.setErrorEnabled(true);
            txtjudul.setError("Judul Matkul is Required");
            return false;
        }
        if(addjam.getText().toString().isEmpty()){
            txtjam.setErrorEnabled(true);
            txtjam.setError("Hari dan Jam Matkul is Required");
            return false;
        }
        if(adddosen.getText().toString().isEmpty()){
            txtdosen.setErrorEnabled(true);
            txtdosen.setError("Dosen Pengampu is Required");
            return false;
        }
        if(addlink.getText().toString().isEmpty()){
            txtlink.setErrorEnabled(true);
            txtlink.setError("Link Kelas is Required");
            return false;
        }
        if(addkode.getText().toString().isEmpty()){
            txtkode.setErrorEnabled(true);
            txtkode.setError("Kode Kelas is Required");
            return false;
        }
        return true;
    }
}
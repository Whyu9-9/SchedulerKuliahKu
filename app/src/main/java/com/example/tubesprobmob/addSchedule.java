package com.example.tubesprobmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class addSchedule extends AppCompatActivity {
Button button;
EditText addjudul, addjam, adddosen, addlink, addkode;
RoomDB database;
MainAdapter adapter;
List<MainData> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
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
                i.putExtra("suc",success);
                startActivity(i);
            }
        });
    }
}
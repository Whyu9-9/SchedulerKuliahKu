package com.example.tubesprobmob;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class scheduleDetail extends AppCompatActivity {
    Button editbtn, deletebutton;
    TextView matkul,hari,dosen, link,kode;
    RoomDB database;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);
        init();
    }

    private void init() {
        matkul = findViewById(R.id.txtjudulMatkul);
        hari = findViewById(R.id.txthariDanJam);
        dosen = findViewById(R.id.txtdosen);
        link = findViewById(R.id.txtlink);
        kode = findViewById(R.id.txtkodeMatkul);

        editbtn = findViewById(R.id.editData);
        deletebutton = findViewById(R.id.deleteData);

        getIncomingExtra();
        getDetail();

        editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(scheduleDetail.this, scheduleEdit.class);
                intent.putExtra("matkul", matkul.getText().toString());
                intent.putExtra("hari", hari.getText().toString());
                intent.putExtra("dosen", dosen.getText().toString());
                intent.putExtra("link", link.getText().toString());
                intent.putExtra("kode", kode.getText().toString());
                intent.putExtra("id", id);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(scheduleDetail.this);
                builder.setTitle("Delete Data");
                builder.setMessage("Apakah anda yakin ingin menghapus data?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i = new Intent(scheduleDetail.this, MainActivity.class);
                                String success = "success";
                                i.putExtra("sucdel",success);
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                builder.show();

            }
        });
    }
    private void getIncomingExtra() {
        if (getIntent().hasExtra("id")) {
            id = getIntent().getIntExtra("id", 0);
            Toast toast = Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void getDetail() {
        database = RoomDB.getInstance(scheduleDetail.this);
        MainData main = database.mainDao().loadById(id);

        matkul.setText(main.getJudulMatkul());
        hari.setText(main.getHariJam());
        dosen.setText(main.getDosen());
        link.setText(main.getLink());
        kode.setText(main.getKodeMatkul());
    }
}
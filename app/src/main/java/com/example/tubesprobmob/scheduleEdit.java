package com.example.tubesprobmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class scheduleEdit extends AppCompatActivity {
    Button saveeditbtn;
    EditText editmatkul,edithari,editdosen, editlink, editkode;
    TextInputLayout layoutmatkul,layouthari,layoutdosen, layoutlink, layoutkode;
    RoomDB database;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_edit);
        init();
    }

    private void init() {
        editmatkul = findViewById(R.id.editjudulMatkul);
        edithari = findViewById(R.id.edithariDanJam);
        editdosen = findViewById(R.id.editdosen);
        editlink = findViewById(R.id.editlink);
        editkode = findViewById(R.id.editkodeMatkul);

        layoutmatkul = findViewById(R.id.txteditjudul);
        layouthari = findViewById(R.id.txteditjam);
        layoutdosen = findViewById(R.id.txteditdosen);
        layoutlink = findViewById(R.id.txteditlink);
        layoutkode = findViewById(R.id.txteditkode);

        saveeditbtn = findViewById(R.id.saveEditData);
        getIncomingExtra();
        saveeditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    edit();
                }
            }
        });
        editmatkul.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editmatkul.getText().toString().isEmpty()){
                    layoutmatkul.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edithari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!edithari.getText().toString().isEmpty()){
                    layouthari.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editdosen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editdosen.getText().toString().isEmpty()){
                    layoutdosen.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editlink.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editlink.getText().toString().isEmpty()){
                    layoutlink.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editkode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editkode.getText().toString().isEmpty()){
                    layoutkode.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private boolean validate() {
        if(editmatkul.getText().toString().isEmpty()){
            layoutmatkul.setErrorEnabled(true);
            layoutmatkul.setError("Judul Matkul is Required");
            return false;
        }
        if(edithari.getText().toString().isEmpty()){
            layouthari.setErrorEnabled(true);
            layouthari.setError("Hari dan Jam Matkul is Required");
            return false;
        }
        if(editdosen.getText().toString().isEmpty()){
            layoutdosen.setErrorEnabled(true);
            layoutdosen.setError("Dosen Pengampu is Required");
            return false;
        }
        if(editlink.getText().toString().isEmpty()){
            layoutdosen.setErrorEnabled(true);
            layoutdosen.setError("Link Kelas is Required");
            return false;
        }
        if(editkode.getText().toString().isEmpty()){
            layoutkode.setErrorEnabled(true);
            layoutkode.setError("Kode Kelas is Required");
            return false;
        }
        return true;
    }

    private void getIncomingExtra() {
        if (getIntent().hasExtra("id")) {
            editmatkul.setText(getIntent().getStringExtra("matkul"));
            edithari.setText(getIntent().getStringExtra("hari"));
            editdosen.setText(getIntent().getStringExtra("dosen"));
            editlink.setText(getIntent().getStringExtra("link"));
            editkode.setText(getIntent().getStringExtra("kode"));
            id = getIntent().getIntExtra("id", 0);
        }
    }

    private void edit() {
        database = RoomDB.getInstance(getApplicationContext());
        database.mainDao().updateSchedule(id, editmatkul.getText().toString(), edithari.getText().toString(), editdosen.getText().toString(),editlink.getText().toString(), editkode.getText().toString());
        MainActivity.recyclerView.getAdapter().notifyDataSetChanged();
        Intent i = new Intent(scheduleEdit.this, MainActivity.class);
        i.putExtra("suced", id);
        startActivity(i);
        finish();
    }
}
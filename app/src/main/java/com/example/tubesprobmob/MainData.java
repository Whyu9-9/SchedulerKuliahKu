package com.example.tubesprobmob;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "schedule")
public class MainData implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "judulMatkul")
    private String judulMatkul;

    @ColumnInfo(name = "hariJam")
    private String hariJam;

    @ColumnInfo(name = "dosen")
    private String dosen;

    @ColumnInfo(name = "link")
    private String link;

    @ColumnInfo(name = "kodeMatkul")
    private String kodeMatkul;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJudulMatkul() {
        return judulMatkul;
    }

    public void setJudulMatkul(String judulMatkul) {
        this.judulMatkul = judulMatkul;
    }

    public String getHariJam() {
        return hariJam;
    }

    public void setHariJam(String hariJam) {
        this.hariJam = hariJam;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }
}

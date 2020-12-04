package com.example.tubesprobmob;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

    @Delete
    void delete(MainData mainData);

    @Delete
    void reset(List<MainData> mainData);

    @Update
    void update(MainData mainData);

    @Query("SELECT * FROM schedule WHERE ID = :sID")
    MainData loadById(int sID);

    @Query("SELECT * FROM schedule")
    List<MainData> getAll();
}

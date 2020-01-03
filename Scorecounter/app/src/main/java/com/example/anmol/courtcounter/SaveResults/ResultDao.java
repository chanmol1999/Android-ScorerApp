package com.example.anmol.courtcounter.SaveResults;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ResultDao {

    @Insert
    void insert(Result result);

    @Delete
    void delete(Result result);

    @Query("DELETE FROM result_table")
    void deleteAllResults();

    @Query("SELECT * FROM result_table ORDER BY title ASC")
    LiveData<List<Result>> getAllResults();
}

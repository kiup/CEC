package com.fmat.uady.cec.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fmat.uady.cec.persistence.entities.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noecutz on 29/11/17.
 */

@Dao
public interface ActionDao {

    @Query("SELECT * FROM history")
    List<Action> getAll();

    @Query("SELECT * FROM history WHERE computer_center LIKE :nameCenter")
    List<Action> findByCenter(String nameCenter);

    @Query("SELECT * FROM history WHERE user LIKE :userName")
    List<Action> findByUser(String userName);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Action action);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertActions(List<Action> actions);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Action action);

    @Delete
    void deleteComputer(Action action);
}

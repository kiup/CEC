package com.fmat.uady.cec.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fmat.uady.cec.persistence.entities.ComputerCenter;

import java.util.List;

/**
 * Created by noecutz on 28/11/17.
 */
@Dao
public interface ComputerCenterDao {

    @Query("SELECT * FROM computer_centers")
    List<ComputerCenter> getAll();

    @Query("SELECT * FROM computer_centers WHERE name LIKE :nameCenter")
    List<ComputerCenter> findByName(String nameCenter);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ComputerCenter computerCenter);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertComputerCenters(List<ComputerCenter> computerCenters);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(ComputerCenter computerCenter);

    @Delete
    void deleteComputer(ComputerCenter computerCenter);
}

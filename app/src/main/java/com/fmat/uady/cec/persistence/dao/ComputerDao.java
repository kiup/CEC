package com.fmat.uady.cec.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fmat.uady.cec.persistence.entities.Computer;

import java.util.List;

/**
 * Created by noecutz on 28/11/17.
 */

@Dao
public interface ComputerDao {

    @Query("SELECT * FROM computer")
    List<Computer> getAll();

    @Query("SELECT * FROM computer WHERE id_computer_center LIKE :nameCenter")
    List<Computer> findByCenter(String nameCenter);

    @Query("SELECT * FROM computer WHERE name_computer LIKE :name")
    Computer findByName(String name);


    @Insert
    void insert(Computer computer);

    @Update
    void update(Computer computer);

    @Delete
    void deleteComputer(Computer computer);

}

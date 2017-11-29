package com.fmat.uady.cec.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.fmat.uady.cec.persistence.entities.Action;
import com.fmat.uady.cec.persistence.entities.User;

import java.util.List;

/**
 * Created by noecutz on 29/11/17.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE user_name LIKE :userName")
    User findByName(String userName);

    @Query("SELECT * FROM users WHERE email LIKE :email")
    User findByEmail(String email);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(List<User> users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);

    @Delete
    void deleteComputer(User user);
}

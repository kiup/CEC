package com.fmat.uady.cec.persistence.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.nfc.tech.NfcA;

/**
 * Created by noecutz on 29/11/17.
 */

@Entity(tableName = "users", indices = {@Index(value ={"user_name"}, unique = true)})
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    private int idUser;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "name")
    private String nombre;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;

    public User() {
    }

    @Ignore
    public User(int idUser, String userName, String nombre, String email, String password) {
        this.idUser = idUser;
        this.userName = userName;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

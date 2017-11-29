package com.fmat.uady.cec.persistence.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by noecutz on 25/11/17.
 */
@Entity(tableName = "computer_centers")
public class ComputerCenter {

    @PrimaryKey
    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    @ColumnInfo(name = "is_turnOn")
    private Boolean isTurnOn;

    public ComputerCenter(String name) {
        this.name = name;
        this.isTurnOn = false;
    }

    public Boolean isTurnOn() {
        return isTurnOn;
    }

    public void setTurnOn(Boolean isTurnOn) {
        this.isTurnOn = isTurnOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

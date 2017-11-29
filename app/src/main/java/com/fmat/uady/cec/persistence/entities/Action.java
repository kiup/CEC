package com.fmat.uady.cec.persistence.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by noecutz on 29/11/17.
 */

@Entity(tableName = "history",
        foreignKeys = @ForeignKey(entity = User.class, parentColumns = "user_name",
                childColumns = "user"), indices = {@Index("user")})
public class Action {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_action")
    private int idAction;

    @ColumnInfo(name = "user")
    private String user;

    @ColumnInfo(name = "computer_center")
    private String computerCenter;

    @ColumnInfo(name = "description")
    private int description;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "time")
    private Date time;


    public Action() {
    }

    @Ignore
    public Action(String user, String computerCenter, int description, Date date, Date time) {
        this.idAction = idAction;
        this.user = user;
        this.computerCenter = computerCenter;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComputerCenter() {
        return computerCenter;
    }

    public void setComputerCenter(String computerCenter) {
        this.computerCenter = computerCenter;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

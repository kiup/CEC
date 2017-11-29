package com.fmat.uady.cec.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.fmat.uady.cec.persistence.converters.ConverterDate;
import com.fmat.uady.cec.persistence.dao.ActionDao;
import com.fmat.uady.cec.persistence.dao.ComputerCenterDao;
import com.fmat.uady.cec.persistence.dao.ComputerDao;
import com.fmat.uady.cec.persistence.dao.UserDao;
import com.fmat.uady.cec.persistence.entities.Action;
import com.fmat.uady.cec.persistence.entities.Computer;
import com.fmat.uady.cec.persistence.entities.ComputerCenter;
import com.fmat.uady.cec.persistence.entities.User;

/**
 * Created by noecutz on 28/11/17.
 */
@Database(entities = {Computer.class, ComputerCenter.class, Action.class, User.class}, version = 1)
@TypeConverters({ConverterDate.class})
public abstract class AppData extends RoomDatabase {
    private static AppData INSTANCE;

    public abstract ComputerDao computerDao();
    public abstract ComputerCenterDao computerCenterDao();
    public abstract ActionDao actionDao();
    public abstract UserDao userDao();

    public static AppData getAppData(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context, AppData.class, "CEC_FMAT").build();
        }
        return INSTANCE;
    }

    public static void destroyInstace(){
        INSTANCE = null;

    }

}

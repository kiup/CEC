package com.fmat.uady.cec.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.fmat.uady.cec.persistence.dao.ComputerCenterDao;
import com.fmat.uady.cec.persistence.dao.ComputerDao;
import com.fmat.uady.cec.persistence.entities.Computer;
import com.fmat.uady.cec.persistence.entities.ComputerCenter;

/**
 * Created by noecutz on 28/11/17.
 */
@Database(entities = {Computer.class, ComputerCenter.class}, version = 1)
public abstract class AppData extends RoomDatabase {
    private static AppData INSTANCE;

    public abstract ComputerDao computerDao();
    public abstract ComputerCenterDao computerCenterDao();

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

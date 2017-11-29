package com.fmat.uady.cec.persistence.database;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import com.fmat.uady.cec.persistence.entities.Computer;
import com.fmat.uady.cec.persistence.entities.ComputerCenter;
import com.fmat.uady.cec.persistence.entities.User;
import com.fmat.uady.cec.persistence.entities.Action;


/**
 * Created by noecutz on 25/11/17.
 */

public class DataInitializer {

    private List<Computer> computers;
    private List<ComputerCenter> computerCenters;
    private List<User> users;
    private List<Action> actions;
    private Context context;

    public DataInitializer(Context context) {
        computers = new ArrayList<>();
        computerCenters = new ArrayList<>();
        users = new ArrayList<>();
        actions = new ArrayList<>();
        this.context = context;
    }


    public void initData() {

        List<ComputerCenter> computerCenters = AppData.getAppData(context).
                computerCenterDao().getAll();

        if(computerCenters.isEmpty()){
            initComputerCenters();
        }

        List<Computer> computers = AppData.getAppData(context).
                computerDao().getAll();

        if(computers.isEmpty()){
            initComputers();
        }

        List<User> users = AppData.getAppData(context).userDao().getAll();

        if(users.isEmpty()){
            initUsers();
        }

        List<Action> actions = AppData.getAppData(context).actionDao().getAll();

        if(actions.isEmpty()){
            initActions();
        }


    }

    public void initComputers(){
        computers.add(new Computer("CC1", "A1", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A2", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A3", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A4", "FG:12:34:45:12", "",true));
        computers.add(new Computer("CC1", "A5", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "B1", "FG:12:34:45:12", "",true));
        computers.add(new Computer("CC1", "B2", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "B3", "FG:12:34:45:12", "",false));
        AppData.getAppData(context).computerDao().insertComputers(computers);
    }

    public void initComputerCenters(){
        computerCenters.add(new ComputerCenter("CC1"));
        computerCenters.add(new ComputerCenter("CC2"));
        computerCenters.add(new ComputerCenter("CC3"));
        computerCenters.add(new ComputerCenter("CC4"));
        computerCenters.add(new ComputerCenter("CC5"));
        computerCenters.add(new ComputerCenter("CC6"));
        AppData.getAppData(context).computerCenterDao().insertComputerCenters(computerCenters);
    }

    public void initUsers(){
       users.add(new User("Admin","Jose Juan",
               "admin@gmail.com", "admin","Administrador" ));
       users.add(new User("Milka","Milka del Rosario",
                "admin@gmail.com","test1" ,"Recepcion"));

       AppData.getAppData(context).userDao().insertUsers(users);

    }

    public void initActions(){

    }


}

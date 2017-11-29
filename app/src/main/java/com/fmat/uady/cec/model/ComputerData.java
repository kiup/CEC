package com.fmat.uady.cec.model;

import java.util.ArrayList;

/**
 * Created by noecutz on 25/11/17.
 */

public class ComputerData {

    private ArrayList<Computer> computers;
    private ArrayList<ComputerCenter> computerCenters;

    public ComputerData() {
        computers = new ArrayList<>();
        computerCenters = new ArrayList<>();
        initComputerCenter();
        initComputers();
    }

    public void initComputers(){
        computers.add(new Computer("CC1", "A1", "AC:D1:B8:EA:64:91", "192.168.228.120",false));
        computers.add(new Computer("CC1", "A2", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A3", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A4", "FG:12:34:45:12", "",true));
        computers.add(new Computer("CC1", "A5", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "B1", "FG:12:34:45:12", "",true));
        computers.add(new Computer("CC1", "B2", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "B3", "FG:12:34:45:12", "",false));
    }

    public void initComputerCenter(){
        computerCenters.add(new ComputerCenter("CC1"));
        computerCenters.add(new ComputerCenter("CC2"));
        computerCenters.add(new ComputerCenter("CC3"));
        computerCenters.add(new ComputerCenter("CC4"));
        computerCenters.add(new ComputerCenter("CC5"));
        computerCenters.add(new ComputerCenter("CC6"));
    }

    public ArrayList<Computer> getComputers(){
        return computers;
    }

    public ArrayList<ComputerCenter> getComputerCenters() {
        return computerCenters;
    }

    public ArrayList<Computer> getComputersByCenter(String center){
        ArrayList<Computer> filteredComputers = new ArrayList<>();
        for(Computer computer : computers){
            if(computer.getIdComputerCenter().equals(center)){
                filteredComputers.add(computer);
            }
        }

        return filteredComputers;
    }
}

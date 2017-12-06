package com.fmat.uady.cec.model;

import java.util.ArrayList;

/**
 * Created by noecutz on 25/11/17.
 */

public class ComputerData {

    private ArrayList<Computer> computers;
    private ArrayList<ComputerCenter> computerCenters;
    private static ComputerData computerData;

    public static ComputerData getInstance(){
        if(computerData == null){
            computerData = new ComputerData();
        }

        return computerData;
    }


    private ComputerData() {
        computers = new ArrayList<>();
        computerCenters = new ArrayList<>();
        initComputerCenter();
        initComputers();
    }

    public void initComputers(){
        computers.add(new Computer("CC8", "A1", "00:1C:7B:AA:0F:C4", "",true));
        computers.add(new Computer("CC8", "A2", "FG:12:34:45:12:59", "",true));
        computers.add(new Computer("CC8", "A3", "FG:12:34:45:12:76", "",true));
        computers.add(new Computer("CC8", "A4", "30:14:4A:54:99:9D", "",true));
    }

    public void initComputerCenter(){
        computerCenters.add(new ComputerCenter("CC1"));
        computerCenters.add(new ComputerCenter("CC2"));
        computerCenters.add(new ComputerCenter("CC3"));
        computerCenters.add(new ComputerCenter("CC4"));
        computerCenters.add(new ComputerCenter("CC5"));
        computerCenters.add(new ComputerCenter("CC6"));
        computerCenters.add(new ComputerCenter("CC7"));
        computerCenters.add(new ComputerCenter("CC8"));
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

    public void updateComputer(Computer ocomputer){
        for (Computer computer: computers) {
            if(computer.getNameComputer().equals(ocomputer.getNameComputer())){
                computer = ocomputer;
            }
        }
    }
}

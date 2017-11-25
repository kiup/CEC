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
    }

    public ArrayList<Computer> getComputers(){
        computers.add(new Computer("CC1", "A1", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A2", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A3", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A4", "FG:12:34:45:12", "",true));
        computers.add(new Computer("CC1", "A5", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A6", "FG:12:34:45:12", "",true));
        computers.add(new Computer("CC1", "A7", "FG:12:34:45:12", "",false));
        computers.add(new Computer("CC1", "A8", "FG:12:34:45:12", "",false));
        return computers;
    }

    public ArrayList<ComputerCenter> getComputerCenters() {
        computerCenters.add(new ComputerCenter("CC1"));
        computerCenters.add(new ComputerCenter("CC2"));
        computerCenters.add(new ComputerCenter("CC3"));
        computerCenters.add(new ComputerCenter("CC4"));
        computerCenters.add(new ComputerCenter("CC5"));
        computerCenters.add(new ComputerCenter("CC6"));
        return computerCenters;
    }
}

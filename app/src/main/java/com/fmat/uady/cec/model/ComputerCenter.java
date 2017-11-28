package com.fmat.uady.cec.model;

/**
 * Created by noecutz on 25/11/17.
 */

public class ComputerCenter {
    private String name;
    private Boolean isOn;

    public ComputerCenter(String name) {
        this.name = name;
        this.isOn = false;
    }

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

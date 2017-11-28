package com.fmat.uady.cec.model;

/**
 * Created by noecutz on 25/11/17.
 */

public class Computer {
    private String idComputerCenter;
    private String nameComputer;
    private String macAddress;
    private String ip;
    private boolean isOn;     //true:encendido false:apagado

    public Computer() {
    }

    public Computer(String idComputerCenter, String nameComputer, String macAddress, String ip, boolean isOn) {
        this.idComputerCenter = idComputerCenter;
        this.nameComputer = nameComputer;
        this.macAddress = macAddress;
        this.ip = ip;
        this.isOn = isOn;
    }

    public String getIdComputerCenter() {
        return idComputerCenter;
    }

    public void setIdComputerCenter(String idComputerCenter) {
        this.idComputerCenter = idComputerCenter;
    }

    public String getNameComputer() {
        return nameComputer;
    }

    public void setNameComputer(String nameComputer) {
        this.nameComputer = nameComputer;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }
}

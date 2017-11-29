package com.fmat.uady.cec.persistence.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

/**
 * Created by noecutz on 25/11/17.
 */
@Entity(tableName = "computers", primaryKeys = {"id_computer_center", "name_computer"},
        foreignKeys = @ForeignKey(entity = ComputerCenter.class, parentColumns = "name", childColumns = "id_computer_center"))
public class Computer {

    @ColumnInfo(name = "id_computer_center")
    @NonNull
    private String idComputerCenter;
    @NonNull
    @ColumnInfo(name = "name_computer")
    private String nameComputer;

    @ColumnInfo(name = "mac_address")
    private String macAddress;

    @ColumnInfo(name = "ip")
    private String ip;

    @ColumnInfo(name = "is_turnOn")
    private boolean isTurnOn;     //true:encendido false:apagado

    public Computer() {

    }

    @Ignore
    public Computer(String idComputerCenter, String nameComputer, String macAddress, String ip, boolean isTurnOn) {
        this.idComputerCenter = idComputerCenter;
        this.nameComputer = nameComputer;
        this.macAddress = macAddress;
        this.ip = ip;
        this.isTurnOn = isTurnOn;
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

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public void setTurnOn(boolean turnOn) {
        this.isTurnOn = turnOn;
    }
}

package com.fmat.uady.cec.model;

import java.util.Date;

/**
 * Created by M on 28/11/2017.
 */

public class History {
    private String idComputer; //Todas las maquinas o codigo de cada maquina
    private String idCenter;   //Es el id del centro de computo
    private String userName;    //Nombre de quien realizo la acción
    private String action;      //encendido/apagado
    private Date date;          //fecha del suceso

    public History() {
    }

    public History(String idComputer, String idCenter, String userName, String action, Date date) {
        this.idComputer = idComputer;
        this.idCenter = idCenter;
        this.userName = userName;
        this.action = action;
        this.date = date;
    }

    public String getIdComputer() {
        return idComputer;
    }

    public void setIdComputer(String idComputer) {
        this.idComputer = idComputer;
    }

    public String getIdCenter() {
        return idCenter;
    }

    public void setIdCenter(String idCenter) {
        this.idCenter = idCenter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return  userName + " el "+ date +
                " realizo " + action + " en " +
                idCenter + " de " + idComputer;
    }
}

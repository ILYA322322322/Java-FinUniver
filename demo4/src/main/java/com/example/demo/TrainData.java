package com.example.demo;
import java.util.Date;

public class TrainData {
    private String train;
    private Date dataO;
    private Date dateP;
    private int vagon;
    private int mesto;
    private String cityGo;
    private String cityTo;

    public TrainData(String train, Date dataO, Date dateP, int vagon, int mesto, String cityGo, String cityTo) {
        this.train = train;
        this.dataO = dataO;
        this.dateP = dateP;
        this.vagon = vagon;
        this.mesto = mesto;
        this.cityGo = cityGo;
        this.cityTo = cityTo;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public Date getDataO() {
        return dataO;
    }

    public void setDataO(Date dataO) {
        this.dataO = dataO;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public int getVagon() {
        return vagon;
    }

    public void setVagon(int vagon) {
        this.vagon = vagon;
    }

    public int getMesto() {
        return mesto;
    }

    public void setMesto(int mesto) {
        this.mesto = mesto;
    }

    public String getCityGo() {
        return cityGo;
    }

    public void setCityGo(String cityGo) {
        this.cityGo = cityGo;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }
}

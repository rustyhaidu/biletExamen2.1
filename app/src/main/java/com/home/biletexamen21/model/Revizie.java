package com.home.biletexamen21.model;

import java.io.Serializable;
import java.util.Objects;

public class Revizie implements Serializable {
    private int numarAuto;
    private int numarKm;
    private String data;
    private int cost;
    private String tip;

    public Revizie(){

    }

    public Revizie(int numarAuto, int numarKm, String data, int cost, String tip) {
        this.numarAuto = numarAuto;
        this.numarKm = numarKm;
        this.data = data;
        this.cost = cost;
        this.tip = tip;
    }

    public int getNumarAuto() {
        return numarAuto;
    }

    public void setNumarAuto(int numarAuto) {
        this.numarAuto = numarAuto;
    }

    public int getNumarKm() {
        return numarKm;
    }

    public void setNumarKm(int numarKm) {
        this.numarKm = numarKm;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Revizie)) return false;
        Revizie revizie = (Revizie) o;
        return numarAuto == revizie.numarAuto &&
                numarKm == revizie.numarKm &&
                cost == revizie.cost &&
                Objects.equals(data, revizie.data) &&
                Objects.equals(tip, revizie.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarAuto, numarKm, data, cost, tip);
    }
}

package com.codegym.model;

public class MoneyConverter {

    private float usd;
    private float vnd;
    private float total;

    public MoneyConverter(float usd, float vnd) {
        this.usd = usd;
        this.vnd = vnd;
    }

    public MoneyConverter() {
    }

    public float getUsd() {
        return usd;
    }

    public void setUsd(float usd) {
        this.usd = usd;
    }

    public float getVnd() {
        return vnd;
    }

    public void setVnd(float vnd) {
        this.vnd = vnd;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "MoneyConverter: " +"\n"+
                "usd: " + usd +"\n"+
                "vnd: " + vnd +"\n"+
                "total: " + total;
    }
}

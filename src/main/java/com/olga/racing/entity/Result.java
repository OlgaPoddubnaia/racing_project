package com.olga.racing.entity;

public class Result {
    private int id;
    private int horseId;
    private String typeOfBet;
    private float money;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getHorseId() {
        return horseId;
    }

    public void setHorseId(int horseId) {
        this.horseId = horseId;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getTypeOfBet() {
        return typeOfBet;
    }

    public void setTypeOfBet(String typeOfBet) {
        this.typeOfBet = typeOfBet;
    }
}

package com.olga.racing.entity;

public class Result {
    private int id;
    private int racingId;
    private int horseId;
    private float money;
    private String typeOfBet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRacingId() {
        return racingId;
    }

    public void setRacingId(int racingId) {
        this.racingId = racingId;
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

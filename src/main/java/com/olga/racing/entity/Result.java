package com.olga.racing.entity;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", horseId=" + horseId +
                ", typeOfBet='" + typeOfBet + '\'' +
                ", money=" + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return id == result.id &&
                horseId == result.horseId &&
                Float.compare(result.money, money) == 0 &&
                typeOfBet.equals(result.typeOfBet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horseId, typeOfBet, money);
    }
}

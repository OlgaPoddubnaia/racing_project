package com.olga.racing.entity;

import java.util.Objects;

public class Horses {

    private int id;
    private String horseName;
    private float rating;
    private int age;
    private String weight;
    private float coefficient;

    public Horses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Horses{" +
                "id=" + id +
                ", horseName='" + horseName + '\'' +
                ", rating=" + rating +
                ", age=" + age +
                ", weight='" + weight + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horses horses = (Horses) o;
        return id == horses.id &&
                Float.compare(horses.rating, rating) == 0 &&
                age == horses.age &&
                Float.compare(horses.coefficient, coefficient) == 0 &&
                Objects.equals(horseName, horses.horseName) &&
                Objects.equals(weight, horses.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horseName, rating, age, weight, coefficient);
    }
}

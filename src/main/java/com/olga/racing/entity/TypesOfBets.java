package com.olga.racing.entity;

import java.util.Objects;

public class TypesOfBets {
    private String type;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypesOfBets{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypesOfBets that = (TypesOfBets) o;
        return type.equals(that.type) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description);
    }
}

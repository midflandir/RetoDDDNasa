package com.sofka.domain.mission.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Charge implements ValueObject<String> {

    private final String value;

    public Charge(String value) {
        this.value = value;
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("The Vo can't be empty");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return Objects.equals(value, charge.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
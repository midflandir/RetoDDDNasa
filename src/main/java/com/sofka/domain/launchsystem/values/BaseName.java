package com.sofka.domain.launchsystem.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BaseName implements ValueObject<String> {

    private final String value;

    public BaseName(String value){
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
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
        BaseName basename = (BaseName) o;
        return Objects.equals(value, basename.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

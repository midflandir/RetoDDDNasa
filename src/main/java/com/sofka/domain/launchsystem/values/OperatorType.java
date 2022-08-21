package com.sofka.domain.launchsystem.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class OperatorType implements ValueObject<String> {

    private final String value;

    public OperatorType(String value){
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
        OperatorType operatorType = (OperatorType) o;
        return Objects.equals(value, operatorType.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

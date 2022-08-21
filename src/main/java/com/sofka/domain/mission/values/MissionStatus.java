package com.sofka.domain.mission.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MissionStatus implements ValueObject<String> {

    private final String value;

    public MissionStatus(String value){
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
        MissionStatus missionStatus = (MissionStatus) o;
        return Objects.equals(value, missionStatus.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

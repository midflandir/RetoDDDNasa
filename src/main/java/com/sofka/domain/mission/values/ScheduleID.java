package com.sofka.domain.mission.values;

import co.com.sofka.domain.generic.Identity;

public class ScheduleID extends Identity {
    private ScheduleID(String id){
        super(id);
    }

    public static ScheduleID of(String id) {
        return new ScheduleID(id);
    }
}

package com.sofka.domain.launchsystem.values;

import co.com.sofka.domain.generic.Identity;

public class LaunchVehicleID extends Identity {
    private LaunchVehicleID(String id){
        super(id);
    }

    public static LaunchVehicleID of(String id) {
        return new LaunchVehicleID(id);
    }
}

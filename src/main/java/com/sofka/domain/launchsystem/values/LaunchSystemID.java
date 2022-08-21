package com.sofka.domain.launchsystem.values;

import co.com.sofka.domain.generic.Identity;

public class LaunchSystemID extends Identity {
    private LaunchSystemID(String id){
        super(id);
    }

    public static LaunchSystemID of(String id) {
        return new LaunchSystemID(id);
    }
}

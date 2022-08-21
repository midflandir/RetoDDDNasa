package com.sofka.domain.launchsystem.values;

import co.com.sofka.domain.generic.Identity;

public class LaunchSystemID extends Identity {
    public LaunchSystemID(String id){
        super(id);
    }
    public LaunchSystemID(){

    }
    public static LaunchSystemID of(String id) {
        return new LaunchSystemID(id);
    }
}

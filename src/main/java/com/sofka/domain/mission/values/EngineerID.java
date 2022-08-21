package com.sofka.domain.mission.values;

import co.com.sofka.domain.generic.Identity;

public class EngineerID extends Identity {
    private EngineerID(String id){
        super(id);
    }
    public EngineerID(){

    }
    public static EngineerID of(String id) {
        return new EngineerID(id);
    }
}

package com.sofka.domain.launchsystem.values;

import co.com.sofka.domain.generic.Identity;

public class OperatorID extends Identity {
    private OperatorID(String id){
        super(id);
    }
    public OperatorID(){

    }
    public static OperatorID of(String id) {
        return new OperatorID(id);
    }
}

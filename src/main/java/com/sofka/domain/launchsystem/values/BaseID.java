package com.sofka.domain.launchsystem.values;

import co.com.sofka.domain.generic.Identity;


public class BaseID extends Identity {
    private BaseID(String id){
        super(id);
    }

    public static BaseID of(String id) {
        return new BaseID(id);
    }
}

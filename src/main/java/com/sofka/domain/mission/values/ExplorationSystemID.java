package com.sofka.domain.mission.values;

import co.com.sofka.domain.generic.Identity;

public class ExplorationSystemID extends Identity {
    private ExplorationSystemID(String id){
        super(id);
    }

    public static ExplorationSystemID of(String id) {
        return new ExplorationSystemID(id);
    }
}

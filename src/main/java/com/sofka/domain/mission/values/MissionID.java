package com.sofka.domain.mission.values;

import co.com.sofka.domain.generic.Identity;

public class MissionID extends Identity{
    public MissionID(String id){
        super(id);
    }
    public MissionID(){

    }
    public static MissionID of(String id) {
        return new MissionID(id);
    }
}

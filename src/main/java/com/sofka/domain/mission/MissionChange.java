package com.sofka.domain.mission;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.mission.events.MissionCreated;

import java.util.HashSet;

public class MissionChange  extends EventChange {
    public MissionChange(Mission mission){
        apply((MissionCreated event) ->{
            mission.missionName = event.getName();
            mission.engineers = new HashSet<>();
            mission.explorationSystems = new HashSet<>();
            mission.schedules = new HashSet<>();
        });
    }





}

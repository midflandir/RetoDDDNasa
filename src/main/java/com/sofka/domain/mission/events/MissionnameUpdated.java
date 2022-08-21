package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionName;

public class MissionnameUpdated extends DomainEvent {

    private final MissionName missionName;

    public MissionnameUpdated(MissionName missionName) {
        super("com.sofka.domain.mission.event.MissionnameUpdated");
        this.missionName = missionName;
    }

    public MissionName getMissionName() {
        return missionName;
    }
}

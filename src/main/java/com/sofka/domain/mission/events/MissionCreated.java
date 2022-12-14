package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;

public class MissionCreated extends DomainEvent {
    private final MissionName MissionName;
    private final MissionStatus missionStatus;

    public MissionCreated(MissionName MissionName, MissionStatus missionStatus) {
        super("com.sofka.domain.mission.event.MissionCreated");
        this.MissionName = MissionName;
        this.missionStatus = missionStatus;
    }

    public MissionName getName() {
        return MissionName;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }
}

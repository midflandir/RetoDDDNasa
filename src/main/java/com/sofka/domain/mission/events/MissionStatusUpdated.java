package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;

public class MissionStatusUpdated  extends DomainEvent {

    private final MissionStatus missionStatus;

    public MissionStatusUpdated(MissionStatus missionStatus) {
        super("com.sofka.domain.mission.event.MissionnameUpdated");
        this.missionStatus = missionStatus;
    }

    public MissionStatus getMissionStatus() {
        return missionStatus;
    }
}

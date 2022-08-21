package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.MissionName;

public class MissionCreated extends DomainEvent {
    private final com.sofka.domain.mission.values.MissionName MissionName;

    public MissionCreated(MissionName MissionName) {
        super("com.sofka.domain.mission.event.MissionCreated");
        this.MissionName = MissionName;
    }

    public MissionName getName() {
        return MissionName;
    }
}

package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.MissionName;

public class MissionCreated extends DomainEvent {
    private final MissionName MIssionName;

    public MissionCreated(MissionName MIssionName) {
        super("com.sofka.domain.mission.event.MissionCreated");
        this.MIssionName = MIssionName;
    }

    public MissionName getName() {
        return MIssionName;
    }
}

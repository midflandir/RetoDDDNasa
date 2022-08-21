package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;

public class ScheduleStartDateUpdated extends DomainEvent {

    private final ScheduleID entityId;
    private final StartDate startDate;

    public ScheduleStartDateUpdated(ScheduleID entityId, StartDate startDate) {
        super("com.sofka.domain.mission.event.ScheduleStartDateUpdated");
        this.entityId = entityId;
        this.startDate = startDate;
    }

    public ScheduleID getEntityId() {
        return entityId;
    }

    public StartDate getStartDate() {
        return startDate;
    }
}

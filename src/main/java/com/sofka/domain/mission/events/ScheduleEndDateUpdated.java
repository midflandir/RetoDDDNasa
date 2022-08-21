package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.ScheduleID;

public class ScheduleEndDateUpdated extends DomainEvent {

    private final ScheduleID entityId;
    private final EndDate endDate;

    public ScheduleEndDateUpdated(ScheduleID entityId, EndDate endDate) {
        super("com.sofka.domain.mission.event.ScheduleEndDateUpdated");
        this.entityId = entityId;
        this.endDate = endDate;
    }

    public ScheduleID getEntityId() {
        return entityId;
    }

    public EndDate getEndDate() {
        return endDate;
    }
}

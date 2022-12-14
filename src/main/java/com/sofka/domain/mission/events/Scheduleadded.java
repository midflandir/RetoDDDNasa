package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;

public class Scheduleadded extends DomainEvent {

    private final ScheduleID entityId;
    private final Operation operation;

    private final StartDate startDate;

    private final EndDate endDate;

    public Scheduleadded(ScheduleID entityId, Operation operation, StartDate startDate, EndDate endDate) {
        super("com.sofka.domain.mission.event.Scheduleadded");
        this.entityId = entityId;
        this.operation = operation;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ScheduleID getEntityId() {
        return entityId;
    }

    public Operation getOperation() {
        return operation;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }
}

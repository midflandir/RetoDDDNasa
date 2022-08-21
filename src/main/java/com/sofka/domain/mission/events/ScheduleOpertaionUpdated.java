package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;

public class ScheduleOpertaionUpdated  extends DomainEvent {

    private final ScheduleID entityId;
    private final Operation operation;

    public ScheduleOpertaionUpdated(ScheduleID entityId, Operation operation) {
        super("com.sofka.domain.mission.event.ScheduleOpertaionUpdated");
        this.entityId = entityId;
        this.operation = operation;
    }

    public ScheduleID getEntityId() {
        return entityId;
    }

    public Operation getOperation() {
        return operation;
    }
}

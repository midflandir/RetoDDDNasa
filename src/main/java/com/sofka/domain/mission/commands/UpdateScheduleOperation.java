package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;

public class UpdateScheduleOperation extends Command {
    private final MissionID missionID;
    private final ScheduleID entityId;
    private final Operation operation;

    public UpdateScheduleOperation(MissionID missionID, ScheduleID entityId, Operation operation) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.operation = operation;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public ScheduleID getEntityId() {
        return entityId;
    }

    public Operation getOperation() {
        return operation;
    }
}

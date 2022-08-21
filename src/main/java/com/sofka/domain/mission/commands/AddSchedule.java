package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;

public class AddSchedule extends Command {

    private final MissionID missionID;

    private final ScheduleID entityId;
    private final Operation operation;
    private final StartDate startDate;
    private final EndDate endDate;



    public AddSchedule(MissionID missionID, ScheduleID entityId, Operation operation, StartDate startDate, EndDate endDate) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.operation = operation;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public StartDate getStartDate() {
        return startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }
}

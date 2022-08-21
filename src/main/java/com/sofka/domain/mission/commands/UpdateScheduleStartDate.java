package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;

public class UpdateScheduleStartDate extends Command {
    private final MissionID missionID;
    private final ScheduleID entityId;
    private final StartDate startDate;

    public UpdateScheduleStartDate(MissionID missionID, ScheduleID entityId, StartDate startDate) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.startDate = startDate;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public ScheduleID getEntityId() {
        return entityId;
    }

    public StartDate getStartDate() {
        return startDate;
    }
}

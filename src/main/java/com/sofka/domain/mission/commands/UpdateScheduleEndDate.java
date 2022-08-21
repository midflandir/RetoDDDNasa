package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.ScheduleID;

public class UpdateScheduleEndDate extends Command {
    private final MissionID missionID;
    private final ScheduleID entityId;
    private final EndDate endDate;

    public UpdateScheduleEndDate(MissionID missionID, ScheduleID entityId, EndDate endDate) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.endDate = endDate;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public ScheduleID getEntityId() {
        return entityId;
    }

    public EndDate getEndDate() {
        return endDate;
    }
}

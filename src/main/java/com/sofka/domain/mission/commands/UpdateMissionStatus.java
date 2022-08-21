package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;

public class UpdateMissionStatus extends Command {
    private final MissionID missionID;
    private final MissionStatus missionStatus;

    public UpdateMissionStatus(MissionID missionID, MissionStatus missionStatus) {
        this.missionID = missionID;
        this.missionStatus = missionStatus;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public MissionStatus MissionStatus() {
        return missionStatus;
    }
}

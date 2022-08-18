package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;

public class CreateMission extends Command {
    private final MissionID missionID;
    private final MissionName missionName;

    public CreateMission(MissionID missionID, MissionName missionName) {
        this.missionID = missionID;
        this.missionName = missionName;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public MissionName getMissionName() {
        return missionName;
    }
}

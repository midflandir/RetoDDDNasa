package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;

public class CreateMission extends Command {
    private final MissionID missionID;
    private final MissionName missionName;

    private final MissionStatus missionStatus;

    public CreateMission(MissionName missionName, MissionStatus missionStatus) {
        this.missionID = new MissionID();
        this.missionName = missionName;
        this.missionStatus = missionStatus;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public MissionName getMissionName() {
        return missionName;
    }
    public MissionStatus getMissionStatus() {
        return missionStatus;
    }
}

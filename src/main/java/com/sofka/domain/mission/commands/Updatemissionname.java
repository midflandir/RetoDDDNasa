package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;

public class Updatemissionname extends Command {
    private final MissionID missionID;
    private final MissionName missionName;

    public Updatemissionname(MissionID missionID, MissionName missionName) {
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

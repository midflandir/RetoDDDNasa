package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionID;

public class ChangeExplorationSystemVersion extends Command {
    private final MissionID missionID;
    private final ExplorationSystemID entityId;
    private final Version version;

    public ChangeExplorationSystemVersion(MissionID missionID, ExplorationSystemID entityId, Version version) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.version = version;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public ExplorationSystemID getEntityId() {
        return entityId;
    }

    public Version getVersion() {
        return version;
    }
}

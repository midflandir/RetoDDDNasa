package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionID;

public class UpdateExplorationSystemModel extends Command {
    private final MissionID missionID;
    private final ExplorationSystemID entityId;
    private final Model model;

    public UpdateExplorationSystemModel(MissionID missionID, ExplorationSystemID entityId, Model model) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.model = model;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public ExplorationSystemID getEntityId() {
        return entityId;
    }

    public Model getModel() {
        return model;
    }
}

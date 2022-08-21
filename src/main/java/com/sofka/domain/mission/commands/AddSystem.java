package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.generic.values.Version;

public class AddSystem extends Command {

    private final MissionID missionID;

    private final ExplorationSystemID entityId;
    private final Model model;
    private final Category category;
    private final Version version;

    public AddSystem(MissionID missionID, ExplorationSystemID entityId, Model model, Category category, Version version) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.model = model;
        this.category = category;
        this.version = version;
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

    public Category getCategory() {
        return category;
    }

    public Version getVersion() {
        return version;
    }
}

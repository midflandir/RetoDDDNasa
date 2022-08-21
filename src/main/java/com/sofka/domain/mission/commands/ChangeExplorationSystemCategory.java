package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionID;

public class ChangeExplorationSystemCategory extends Command {
    private final MissionID missionID;
    private final ExplorationSystemID entityId;
    private final Category category;

    public ChangeExplorationSystemCategory(MissionID missionID, ExplorationSystemID entityId, Category category) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.category = category;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public ExplorationSystemID getEntityId() {
        return entityId;
    }

    public Category getCategory() {
        return category;
    }
}

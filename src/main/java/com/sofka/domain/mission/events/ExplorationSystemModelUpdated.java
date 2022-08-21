package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.mission.values.ExplorationSystemID;

public class ExplorationSystemModelUpdated  extends DomainEvent {

    private final ExplorationSystemID entityId;
    private final Model model;

    public ExplorationSystemModelUpdated(ExplorationSystemID entityId, Model model) {
        super("com.sofka.domain.mission.event.ExplorationSystemModelUpdated");
        this.entityId = entityId;
        this.model = model;
    }

    public ExplorationSystemID getEntityId() {
        return entityId;
    }

    public Model getModel() {
        return model;
    }
}

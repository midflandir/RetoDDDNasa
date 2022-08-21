package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.Category;

public class ExplorationSystemCategoryChanged extends DomainEvent {

    private final ExplorationSystemID entityId;
    private final Category category;

    public ExplorationSystemCategoryChanged(ExplorationSystemID entityId, Category category) {
        super("com.sofka.domain.mission.event.ExplorationSystemCategoryChanged");
        this.entityId = entityId;
        this.category = category;
    }

    public ExplorationSystemID getEntityId() {
        return entityId;
    }

    public Category getCategory() {
        return category;
    }
}

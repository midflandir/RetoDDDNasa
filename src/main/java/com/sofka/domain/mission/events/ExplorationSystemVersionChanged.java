package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.mission.values.ExplorationSystemID;

public class ExplorationSystemVersionChanged  extends DomainEvent {

    private final ExplorationSystemID entityId;
    private final Version version;

    public ExplorationSystemVersionChanged(ExplorationSystemID entityId, Version version) {
        super("com.sofka.domain.mission.event.ExplorationSystemVersionChanged");
        this.entityId = entityId;
        this.version = version;
    }

    public ExplorationSystemID getEntityId() {
        return entityId;
    }

    public Version getVersion() {
        return version;
    }
}

package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;

public class BaseNameUpdated extends DomainEvent {

    private final BaseID entityId;
    private final BaseName baseName;

    public BaseNameUpdated(BaseID entityId, BaseName baseName) {
        super("com.sofka.domain.launchsystem.event.BaseNameUpdated");
        this.entityId = entityId;
        this.baseName = baseName;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public BaseName getBaseName() {
        return baseName;
    }
}

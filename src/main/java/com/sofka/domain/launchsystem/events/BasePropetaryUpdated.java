package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.Plataform;
import com.sofka.domain.launchsystem.values.Propetary;

public class BasePropetaryUpdated extends DomainEvent {

    private final BaseID entityId;
    private final Propetary propetary;

    public BasePropetaryUpdated(BaseID entityId, Propetary propetary) {
        super("com.sofka.domain.launchsystem.event.BasePropetaryUpdated");
        this.entityId = entityId;
        this.propetary = propetary;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public Propetary getPropetary() {
        return propetary;
    }
}

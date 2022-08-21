package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.Plataform;

public class BasePlataformChanged extends DomainEvent {

    private final BaseID entityId;
    private final Plataform plataform;

    public BasePlataformChanged(BaseID entityId, Plataform plataform) {
        super("com.sofka.domain.launchsystem.event.BasePlataformChanged");
        this.entityId = entityId;
        this.plataform = plataform;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public Plataform getPlataform() {
        return plataform;
    }
}

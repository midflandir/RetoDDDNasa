package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.Location;
import com.sofka.domain.launchsystem.values.Plataform;
import com.sofka.domain.launchsystem.values.Propetary;

public class Baseadded extends DomainEvent {

    private final BaseID entityId;
    private final BaseName basename;

    private final Plataform plataform;

    private final Propetary propetary;

    private final Location location;

    public Baseadded( BaseID entityId, BaseName basename, Plataform plataform, Propetary propetary, Location location) {
        super("com.sofka.domain.launchsystem.event.Baseadded");
        this.entityId = entityId;
        this.basename = basename;
        this.plataform = plataform;
        this.propetary = propetary;
        this.location = location;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public BaseName getBasename() {
        return basename;
    }

    public Plataform getPlataform() {
        return plataform;
    }

    public Propetary getPropetary() {
        return propetary;
    }

    public Location getLocation() {
        return location;
    }
}

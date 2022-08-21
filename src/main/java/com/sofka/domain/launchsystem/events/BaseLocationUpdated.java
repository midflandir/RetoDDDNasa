package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.Location;

public class BaseLocationUpdated extends DomainEvent {

    private final BaseID entityId;
    private final Location location;

    public BaseLocationUpdated( BaseID entityId, Location location) {
        super("com.sofka.domain.launchsystem.event.BaseLocationUpdated");
        this.entityId = entityId;
        this.location = location;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public Location getLocation() {
        return location;
    }
}

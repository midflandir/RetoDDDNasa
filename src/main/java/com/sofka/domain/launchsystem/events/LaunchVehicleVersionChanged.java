package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;

public class LaunchVehicleVersionChanged extends DomainEvent {

    private final LaunchVehicleID entityId;
    private final Version version;

    public LaunchVehicleVersionChanged(LaunchVehicleID entityId, Version version) {
        super("com.sofka.domain.launchsystem.event.LaunchVehicleVersionChanged");
        this.entityId = entityId;
        this.version = version;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Version getVersion() {
        return version;
    }
}

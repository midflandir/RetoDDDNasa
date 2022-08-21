package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Thrust;

public class LaunchVehicleThrustChanged extends DomainEvent {

    private final LaunchVehicleID entityId;
    private final Thrust thrust;

    public LaunchVehicleThrustChanged(LaunchVehicleID entityId, Thrust thrust) {
        super("com.sofka.domain.launchsystem.event.LaunchVehicleThrustChanged");
        this.entityId = entityId;
        this.thrust = thrust;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Thrust getThrust() {
        return thrust;
    }
}

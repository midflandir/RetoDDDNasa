package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;

public class LaunchVehicleModelUpdated extends DomainEvent {

    private final LaunchVehicleID entityId;
    private final Model model;

    public LaunchVehicleModelUpdated(LaunchVehicleID entityId, Model model) {
        super("com.sofka.domain.launchsystem.event.LaunchVehicleModelUpdated");
        this.entityId = entityId;
        this.model = model;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Model getModel() {
        return model;
    }
}

package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;
import com.sofka.domain.launchsystem.values.Propetary;

public class LaunchVehicleManufacturerUpdated extends DomainEvent {

    private final LaunchVehicleID entityId;
    private final Manufacturer manufacturer;

    public LaunchVehicleManufacturerUpdated(LaunchVehicleID entityId, Manufacturer manufacturer) {
        super("com.sofka.domain.launchsystem.event.LaunchVehicleManufacturerUpdated");
        this.entityId = entityId;
        this.manufacturer = manufacturer;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}

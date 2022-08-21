package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;
import com.sofka.domain.launchsystem.values.Thrust;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.Salary;

public class LaunchVehicleAdded extends DomainEvent {

    private final LaunchVehicleID entityId;
    private final Model model;
    private final Manufacturer manufacturer;

    private final Thrust thrust;
    private final Version version;

    public LaunchVehicleAdded(LaunchVehicleID entityId, Model model, Manufacturer manufacturer, Thrust thrust, Version version) {
        super("com.sofka.domain.launchsystem.event.MissionCreated");
        this.entityId = entityId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.thrust = thrust;
        this.version = version;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Model getModel() {
        return model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Thrust getThrust() {
        return thrust;
    }

    public Version getVersion() {
        return version;
    }
}

package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.launchsystem.values.Thrust;
import com.sofka.domain.generic.values.Version;

public class AddLaunchVehicle extends Command {

    private final LaunchSystemID launchSystemID;
    private final LaunchVehicleID entityId;
    private final Model model;
    private final Manufacturer manufacturer;
    private final Thrust thrust;
    private final Version version;

    public AddLaunchVehicle(LaunchSystemID launchSystemID, LaunchVehicleID entityId, Model model, Manufacturer manufacturer, Thrust thrust, Version version) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.model = model;
        this.manufacturer = manufacturer;
        this.thrust = thrust;
        this.version = version;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
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

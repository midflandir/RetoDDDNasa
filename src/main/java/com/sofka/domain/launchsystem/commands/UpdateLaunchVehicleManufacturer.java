package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;

public class UpdateLaunchVehicleManufacturer extends Command {
    private final LaunchSystemID launchSystemID;
    private final LaunchVehicleID entityId;
    private final Manufacturer manufacturer;

    public UpdateLaunchVehicleManufacturer(LaunchSystemID launchSystemID, LaunchVehicleID entityId, Manufacturer manufacturer) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.manufacturer = manufacturer;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}

package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;

public class UpdateLaunchVehicleModel extends Command {
    private final LaunchSystemID launchSystemID;
    private final LaunchVehicleID entityId;
    private final Model model;

    public UpdateLaunchVehicleModel(LaunchSystemID launchSystemID, LaunchVehicleID entityId, Model model) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.model = model;
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
}

package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Thrust;

public class ChangLaunchVehicleThrust extends Command {
    private final LaunchSystemID launchSystemID;
    private final LaunchVehicleID entityId;
    private final Thrust thrust;

    public ChangLaunchVehicleThrust(LaunchSystemID launchSystemID, LaunchVehicleID entityId, Thrust thrust) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.thrust = thrust;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Thrust getThrust() {
        return thrust;
    }
}

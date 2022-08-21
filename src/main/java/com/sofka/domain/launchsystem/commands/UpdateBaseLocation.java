package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.Location;
import com.sofka.domain.launchsystem.values.Plataform;

public class UpdateBaseLocation extends Command {
    private final LaunchSystemID launchSystemID;
    private final BaseID entityId;
    private final Location location;

    public UpdateBaseLocation(LaunchSystemID launchSystemID, BaseID entityId, Location location) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.location = location;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public Location getLocation() {
        return location;
    }
}

package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;

public class ChangeLaunchVehicleVersion extends Command {
    private final LaunchSystemID launchSystemID;
    private final LaunchVehicleID entityId;
    private final Version version;

    public ChangeLaunchVehicleVersion(LaunchSystemID launchSystemID, LaunchVehicleID entityId, Version version) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.version = version;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public LaunchVehicleID getEntityId() {
        return entityId;
    }

    public Version getVersion() {
        return version;
    }
}

package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.Location;

public class UpdatedBaseName extends Command {
    private final LaunchSystemID launchSystemID;
    private final BaseID entityId;
    private final BaseName baseName;

    public UpdatedBaseName(LaunchSystemID launchSystemID, BaseID entityId, BaseName baseName) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.baseName = baseName;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public BaseName getBaseName() {
        return baseName;
    }
}

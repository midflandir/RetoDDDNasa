package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.Propetary;

public class UpdatedBasePropetary extends Command {
    private final LaunchSystemID launchSystemID;
    private final BaseID entityId;
    private final Propetary propetary;

    public UpdatedBasePropetary(LaunchSystemID launchSystemID, BaseID entityId, Propetary propetary) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.propetary = propetary;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public Propetary getPropetary() {
        return propetary;
    }
}

package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.Plataform;

public class ChangeBasePlataform extends Command {
    private final LaunchSystemID launchSystemID;
    private final BaseID entityId;
    private final Plataform plataform;

    public ChangeBasePlataform(LaunchSystemID launchSystemID, BaseID entityId, Plataform plataform) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.plataform = plataform;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public BaseID getEntityId() {
        return entityId;
    }

    public Plataform getPlataform() {
        return plataform;
    }
}

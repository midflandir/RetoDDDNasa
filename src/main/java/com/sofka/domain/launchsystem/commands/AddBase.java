package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.Location;
import com.sofka.domain.launchsystem.values.Plataform;
import com.sofka.domain.launchsystem.values.Propetary;

public class AddBase extends Command {

    private final LaunchSystemID launchSystemID;
    private final BaseID entityId;
    private final BaseName baseName;
    private final Plataform plataform;
    private final Propetary propetary;
    private final Location location;

    public AddBase(LaunchSystemID launchSystemID, BaseID entityId, BaseName baseName, Plataform plataform, Propetary propetary, Location location) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.baseName = baseName;
        this.plataform = plataform;
        this.propetary = propetary;
        this.location = location;
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

    public Plataform getPlataform() {
        return plataform;
    }

    public Propetary getPropetary() {
        return propetary;
    }

    public Location getLocation() {
        return location;
    }
}

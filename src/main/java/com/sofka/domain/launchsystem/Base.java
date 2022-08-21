package com.sofka.domain.launchsystem;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.Location;
import com.sofka.domain.launchsystem.values.Plataform;
import com.sofka.domain.launchsystem.values.Propetary;

import java.util.Objects;

public class Base extends Entity<BaseID> {
    private BaseName basename;

    private Plataform plataform;

    private Propetary propetary;

    private Location location;
    public Base(BaseID entityId, BaseName basename, Plataform plataform, Propetary propetary, Location location) {
        super(entityId);
        this.basename = basename;
        this.plataform = plataform;
        this.propetary = propetary;
        this.location = location;
    }


    public void UpdateName(BaseName basename){
        this.basename = Objects.requireNonNull(basename);
    }

    public void ChangePlataform(Plataform plataform){
        this.plataform = Objects.requireNonNull(plataform);
    }

    public void UpdatePropetary(Propetary propetary){
        this.propetary = Objects.requireNonNull(propetary);
    }

    public void UpdateLocation(Location location){
        this.location = Objects.requireNonNull(location);
    }

    public BaseName operation() {
        return basename;
    }
    public Plataform plataform() {
        return plataform;
    }

    public Propetary propetary() {
        return propetary;
    }
    public Location location() {
        return location;
    }
}

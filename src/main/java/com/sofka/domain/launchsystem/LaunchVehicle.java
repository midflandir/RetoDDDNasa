package com.sofka.domain.launchsystem;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.launchsystem.values.Thrust;
import com.sofka.domain.generic.values.Version;

import java.util.Objects;

public class LaunchVehicle extends Entity<LaunchVehicleID> {
    private Model model;
    private Manufacturer manufacturer;

    private Thrust thrust;
    private Version version;
    public LaunchVehicle(LaunchVehicleID entityId, Model model, Manufacturer manufacturer, Thrust thrust, Version version) {
        super(entityId);
        this.model = model;
        this.manufacturer = manufacturer;
        this.thrust = thrust;
        this.version = version;
    }

    public void UpdateModel( Model model){
        this.model = Objects.requireNonNull(model);
    }

    public void UpdateManufacturer(Manufacturer manufacturer){
        this.manufacturer = Objects.requireNonNull(manufacturer);
    }

    public void ChangeThrust(Thrust thrust){
        this.thrust = Objects.requireNonNull(thrust);
    }

    public void ChangeVersion(Version version){
        this.version = Objects.requireNonNull(version);
    }

    public Model model() {
        return model;
    }

    public Manufacturer manufacturer() {
        return manufacturer;
    }

    public Thrust thrust() {
        return thrust;
    }
    public Version salary() {
        return version;
    }
}

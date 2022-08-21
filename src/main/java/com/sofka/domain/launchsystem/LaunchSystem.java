package com.sofka.domain.launchsystem;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.events.BaseLocationUpdated;
import com.sofka.domain.launchsystem.events.BaseNameUpdated;
import com.sofka.domain.launchsystem.events.BasePlataformChanged;
import com.sofka.domain.launchsystem.events.BasePropetaryUpdated;
import com.sofka.domain.launchsystem.events.Baseadded;
import com.sofka.domain.launchsystem.events.LaunchDateUpdated;
import com.sofka.domain.launchsystem.events.LaunchSystemCreated;
import com.sofka.domain.launchsystem.events.LaunchVehicleAdded;
import com.sofka.domain.launchsystem.events.LaunchVehicleManufacturerUpdated;
import com.sofka.domain.launchsystem.events.LaunchVehicleModelUpdated;
import com.sofka.domain.launchsystem.events.LaunchVehicleThrustChanged;
import com.sofka.domain.launchsystem.events.LaunchVehicleVersionChanged;
import com.sofka.domain.launchsystem.events.OperatorNameUpdated;
import com.sofka.domain.launchsystem.events.OperatorTypeChanged;
import com.sofka.domain.launchsystem.events.Operatoradded;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.LaunchDate;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Location;
import com.sofka.domain.launchsystem.values.Manufacturer;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorName;
import com.sofka.domain.launchsystem.values.OperatorType;
import com.sofka.domain.launchsystem.values.Plataform;
import com.sofka.domain.launchsystem.values.Propetary;
import com.sofka.domain.launchsystem.values.Thrust;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class LaunchSystem extends AggregateEvent<LaunchSystemID> {

    protected LaunchDate launchDate;
    protected Set<LaunchVehicle> launchVehicles;
    protected Set<Operator> operators;
    protected Set<Base> bases;

    public LaunchSystem(LaunchSystemID entityId, LaunchDate launchDate) {
        super(entityId);
        appendChange(new LaunchSystemCreated(launchDate)).apply();
        subscribe(new LaunchSystemChange(this));
    }
    public LaunchSystem(LaunchSystemID entityId) {
        super(entityId);
        subscribe(new LaunchSystemChange(this));
    }

    public static LaunchSystem from(LaunchSystemID launchSystemID, List<DomainEvent> events){
        var launchSystem = new LaunchSystem(launchSystemID);
        events.forEach(launchSystem::applyEvent);
        return launchSystem;
    }

    public void UpdateLaunchDate(LaunchDate launchDate){
        Objects.requireNonNull(launchDate);
        appendChange(new LaunchDateUpdated(launchDate)).apply();
    }


    public void AddLaunchVehicle(LaunchVehicleID entityId, Model model, Manufacturer manufacturer, Thrust thrust, Version version){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(model);
        Objects.requireNonNull(manufacturer);
        Objects.requireNonNull(thrust);
        Objects.requireNonNull(version);
        appendChange(new LaunchVehicleAdded(entityId, model, manufacturer, thrust, version)).apply();
    }


    public void AddBase(BaseID entityId, BaseName baseName, Plataform plataform, Propetary propetary, Location location){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(baseName);
        Objects.requireNonNull(plataform);
        Objects.requireNonNull(propetary);
        Objects.requireNonNull(location);
        appendChange(new Baseadded(entityId, baseName, plataform, propetary, location)).apply();
    }


    public void AddOperator(OperatorID entityId, OperatorName operatorName, OperatorType operatorType){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(operatorName);
        Objects.requireNonNull(operatorType);
        appendChange(new Operatoradded(entityId,operatorName, operatorType)).apply();
    }


    public void UpdateLaunchVehicleModel(LaunchVehicleID entityId, Model model){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(model);
        appendChange(new LaunchVehicleModelUpdated(entityId, model)).apply();
    }


    public void UpdateLaunchVehicleManufacturer(LaunchVehicleID entityId, Manufacturer manufacturer){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(manufacturer);
        appendChange(new LaunchVehicleManufacturerUpdated(entityId, manufacturer)).apply();
    }

    public void ChangLaunchVehicleThrust(LaunchVehicleID entityId, Thrust thrust ){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(thrust);
        appendChange(new LaunchVehicleThrustChanged(entityId, thrust)).apply();
    }

    public void ChangeLaunchVehicleVersion(LaunchVehicleID entityId, Version version){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(version);
        appendChange(new LaunchVehicleVersionChanged(entityId, version)).apply();
    }


    public void UpdatedBaseName(BaseID entityId,  BaseName baseName){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(baseName);
        appendChange(new BaseNameUpdated(entityId, baseName)).apply();
    }


    public void ChangeBasePlataform(BaseID entityId, Plataform plataform){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(plataform);
        appendChange(new BasePlataformChanged(entityId, plataform)).apply();
    }


    public void UpdatedBasePropetary(BaseID entityId, Propetary propetary){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(propetary);
        appendChange(new BasePropetaryUpdated(entityId, propetary)).apply();
    }


    public void UpdateBaseLocation(BaseID entityId, Location location){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(location);
        appendChange(new BaseLocationUpdated(entityId, location)).apply();
    }


    public void UpdateOperatorName(OperatorID entityId, OperatorName operatorName){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(operatorName);
        appendChange(new OperatorNameUpdated(entityId, operatorName)).apply();
    }


    public void ChangeoperatorType(OperatorID entityId, OperatorType operatorType){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(operatorType);
        appendChange(new OperatorTypeChanged(entityId, operatorType)).apply();
    }



    public Optional<Base> getBaseById(BaseID entityID){
        return bases().stream().filter((base -> base.identity().equals(entityID))).findFirst();
    }

    public Optional<LaunchVehicle> getLaunchVehicleById(LaunchVehicleID entityID){
        return launchVehicles().stream().filter((launchVehicle -> launchVehicle.identity().equals(entityID))).findFirst();
    }
    public Optional<Operator> getOperatorById(OperatorID entityID){
        return operators().stream().filter((operator -> operator.identity().equals(entityID))).findFirst();
    }


    public LaunchDate launchDate() {
        return launchDate;
    }

    public Set<LaunchVehicle> launchVehicles() {
        return launchVehicles;
    }

    public Set<Operator> operators() {
        return operators;
    }

    public Set<Base> bases() {
        return bases;
    }
}
package com.sofka.domain.launchsystem;

import co.com.sofka.domain.generic.EventChange;
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

import java.util.HashSet;

public class LaunchSystemChange extends EventChange {
    public LaunchSystemChange(LaunchSystem launchSystem){
        apply((LaunchSystemCreated event) ->{
            launchSystem.launchDate = event.getLaunchDate();
            launchSystem.launchVehicles =  new HashSet<>();
            launchSystem.bases = new HashSet<>();
            launchSystem.operators = new HashSet<>();

        });

        apply((Baseadded event)->{

            launchSystem.bases.add(new Base(
                    event.getEntityId(),
                    event.getBasename(),
                    event.getPlataform(),
                    event.getPropetary(),
                    event.getLocation()
            ));
        });

        apply((LaunchVehicleAdded event)->{

            launchSystem.launchVehicles.add(new LaunchVehicle(
                    event.getEntityId(),
                    event.getModel(),
                    event.getManufacturer(),
                    event.getThrust(),
                    event.getVersion()
            ));
        });

        apply((Operatoradded event)->{

            launchSystem.operators.add(new Operator(
                    event.getEntityId(),
                    event.getOperatorName(),
                    event.getOperatorType()
            ));
        });

        apply((LaunchDateUpdated event)->{
            launchSystem.launchDate =event.getLaunchDate();
        });

        apply((LaunchVehicleModelUpdated event)->{
            var launchvehicle = launchSystem.getLaunchVehicleById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            launchvehicle.UpdateModel(event.getModel());
        });

        apply((LaunchVehicleManufacturerUpdated event)->{
            var launchvehicle = launchSystem.getLaunchVehicleById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            launchvehicle.UpdateManufacturer(event.getManufacturer());
        });

        apply((LaunchVehicleVersionChanged event)->{
            var launchvehicle = launchSystem.getLaunchVehicleById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            launchvehicle.ChangeVersion(event.getVersion());
        });

        apply((LaunchVehicleThrustChanged event)->{
            var launchvehicle = launchSystem.getLaunchVehicleById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            launchvehicle.ChangeThrust(event.getThrust());
        });

        apply((BaseNameUpdated event)->{
            var base = launchSystem.getBaseById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            base.UpdateName(event.getBaseName());
        });

        apply((BasePlataformChanged event)->{
            var base = launchSystem.getBaseById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            base.ChangePlataform(event.getPlataform());
        });

        apply((BasePropetaryUpdated event)->{
            var base = launchSystem.getBaseById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            base.UpdatePropetary(event.getPropetary());
        });

        apply((BaseLocationUpdated event)->{
            var base = launchSystem.getBaseById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            base.UpdateLocation(event.getLocation());
        });

        apply((OperatorNameUpdated event)->{
            var operator = launchSystem.getOperatorById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            operator.UpdateName(event.getOperatorName());
        });

        apply((OperatorTypeChanged event)->{
            var operator = launchSystem.getOperatorById(event.getEntityId()).orElseThrow(()->new IllegalArgumentException("Invalid id to reach the entity"));
            operator.ChangeType(event.getOperatorType());
        });

    }

}

package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;

public class EngineerChargeChanged extends DomainEvent {

    private final EngineerID entityId;
    private final Charge charge;

    public EngineerChargeChanged(EngineerID entityId, Charge charge) {
        super("com.sofka.domain.mission.event.EngineerChargeChanged");
        this.entityId = entityId;
        this.charge = charge;
    }

    public EngineerID getEntityId() {
        return entityId;
    }

    public Charge getCharge() {
        return charge;
    }
}

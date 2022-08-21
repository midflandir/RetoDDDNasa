package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorName;

public class OperatorNameUpdated  extends DomainEvent {

    private final OperatorID entityId;
    private final OperatorName operatorName;

    public OperatorNameUpdated(OperatorID entityId, OperatorName operatorName) {
        super("com.sofka.domain.launchsystem.event.OperatorNameUpdated");
        this.entityId = entityId;
        this.operatorName = operatorName;
    }

    public OperatorID getEntityId() {
        return entityId;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }
}

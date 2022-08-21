package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorType;

public class OperatorTypeChanged extends DomainEvent {

    private final OperatorID entityId;
    private final OperatorType operatorType;

    public OperatorTypeChanged(OperatorID entityId, OperatorType operatorType) {
        super("com.sofka.domain.launchsystem.event.OperatorTypeChanged");
        this.entityId = entityId;
        this.operatorType = operatorType;
    }

    public OperatorID getEntityId() {
        return entityId;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }
}

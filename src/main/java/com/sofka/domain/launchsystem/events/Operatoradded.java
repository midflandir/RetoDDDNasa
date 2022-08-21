package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorName;
import com.sofka.domain.launchsystem.values.OperatorType;

public class Operatoradded extends DomainEvent {

    private final OperatorID entityId;
    private final OperatorName operatorName;
    private final OperatorType operatorType;

    public Operatoradded( OperatorID entityId, OperatorName operatorName, OperatorType operatorType) {
        super("com.sofka.domain.launchsystem.event.Operatoradded");
        this.entityId = entityId;
        this.operatorName = operatorName;
        this.operatorType = operatorType;
    }

    public OperatorID getEntityId() {
        return entityId;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }
}

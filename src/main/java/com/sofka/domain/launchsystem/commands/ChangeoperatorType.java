package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorType;

public class ChangeoperatorType extends Command {
    private final LaunchSystemID launchSystemID;
    private final OperatorID entityId;
    private final OperatorType operatorType;

    public ChangeoperatorType(LaunchSystemID launchSystemID, OperatorID entityId, OperatorType operatorType) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.operatorType = operatorType;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public OperatorID getEntityId() {
        return entityId;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }
}

package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorName;
import com.sofka.domain.launchsystem.values.OperatorType;

public class AddOperator extends Command {

    private final LaunchSystemID launchSystemID;
    private final OperatorID entityId;
    private final OperatorName operatorName;
    private final OperatorType operatorType;

    public AddOperator(LaunchSystemID launchSystemID, OperatorID entityId, OperatorName operatorName, OperatorType operatorType) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.operatorName = operatorName;
        this.operatorType = operatorType;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public OperatorID getEntityId() {
        return entityId;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }

    public OperatorType getType() {
        return operatorType;
    }
}

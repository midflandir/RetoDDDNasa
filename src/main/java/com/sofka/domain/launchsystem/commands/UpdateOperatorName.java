package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorName;
import com.sofka.domain.launchsystem.values.OperatorType;

public class UpdateOperatorName  extends Command {
    private final LaunchSystemID launchSystemID;
    private final OperatorID entityId;
    private final OperatorName operatorName;

    public UpdateOperatorName(LaunchSystemID launchSystemID, OperatorID entityId, OperatorName operatorName) {
        this.launchSystemID = launchSystemID;
        this.entityId = entityId;
        this.operatorName = operatorName;
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
}

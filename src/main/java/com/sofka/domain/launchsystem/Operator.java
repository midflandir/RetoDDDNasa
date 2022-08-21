package com.sofka.domain.launchsystem;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorName;
import com.sofka.domain.launchsystem.values.OperatorType;

import java.util.Objects;

public class Operator extends Entity<OperatorID> {
private OperatorName operatorName;
private OperatorType operatorType;

public Operator(OperatorID entityId, OperatorName operatorName, OperatorType operatorType) {
        super(entityId);
        this.operatorName = operatorName;
        this.operatorType = operatorType;

        }

public void UpdateName( OperatorName operatorName){
        this.operatorName = Objects.requireNonNull(operatorName);
        }

public void ChangeType(OperatorType operatorType){
        this.operatorType = Objects.requireNonNull(operatorType);
        }



public OperatorName operatorName() {
        return operatorName;
        }
public OperatorType salary() {
        return operatorType;
        }
        }

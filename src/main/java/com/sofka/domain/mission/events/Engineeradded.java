package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.Salary;

public class Engineeradded extends DomainEvent {

    private final EngineerID entityId;
    private  final EngineerName engineerName;

    private  final Charge charge;

    private  final Salary salary;

    public Engineeradded(EngineerID entityId, EngineerName engineerName, Charge charge, Salary salary) {
        super("com.sofka.domain.mission.event.Engineeradded");
        this.entityId = entityId;
        this.engineerName = engineerName;
        this.charge = charge;
        this.salary = salary;
    }

    public EngineerID getEntityId() {
        return entityId;
    }

    public EngineerName getEngineerName() {
        return engineerName;
    }

    public Charge getCharge() {
        return charge;
    }

    public Salary getSalary() {
        return salary;
    }
}

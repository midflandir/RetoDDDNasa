package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.Salary;

public class EngineerSalaryIncreased extends DomainEvent {

    private final EngineerID entityId;
    private final Salary salary;

    public EngineerSalaryIncreased(EngineerID entityId, Salary salary) {
        super("com.sofka.domain.mission.event.EngineerSalaryIncreased");
        this.entityId = entityId;
        this.salary = salary;
    }

    public EngineerID getEntityId() {
        return entityId;
    }

    public Salary getSalary() {
        return salary;
    }
}

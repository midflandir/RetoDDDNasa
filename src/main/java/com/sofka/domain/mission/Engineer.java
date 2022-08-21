package com.sofka.domain.mission;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.Salary;

import java.util.Objects;

public class Engineer extends Entity<EngineerID> {
    private EngineerName engineerName;

    private Charge charge;

    private Salary salary;
    public Engineer(EngineerID entityId, EngineerName engineerName, Charge charge, Salary salary) {
        super(entityId);
        this.engineerName = engineerName;
        this.charge = charge;
        this.salary = salary;
    }


    public void ChangeEngineerCharge( Charge charge){
        this.charge = Objects.requireNonNull(charge);
    }

    public void IncreaseSalary(Salary salary){
        this.salary = Objects.requireNonNull(salary);
    }

    public void ReduceSalary(Salary salary){
        this.salary = Objects.requireNonNull(salary);
    }

    public EngineerName engineerName() {
        return engineerName;
    }
    public Charge charge() {
        return charge;
    }
    public Salary salary() {
        return salary;
    }
}

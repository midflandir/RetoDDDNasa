package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.Salary;

public class AddEngineer extends Command {

    private final MissionID missionID;
    private final EngineerID entityId;
    private final EngineerName engineerName;
    private final Charge charge;

    private final Salary salary;


    public AddEngineer(MissionID missionID, EngineerID entityId, EngineerName engineerName, Charge charge, Salary salary) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.engineerName = engineerName;
        this.charge = charge;
        this.salary = salary;
    }

    public MissionID getMissionID() {
        return missionID;
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

package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.Salary;

public class IncreaseEngineerSalary extends Command {
    private final MissionID missionID;
    private final EngineerID entityId;
    private final Salary salary;

    public IncreaseEngineerSalary(MissionID missionID, EngineerID entityId, Salary salary) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.salary = salary;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public EngineerID getEntityId() {
        return entityId;
    }

    public Salary getSalary() {
        return salary;
    }
}

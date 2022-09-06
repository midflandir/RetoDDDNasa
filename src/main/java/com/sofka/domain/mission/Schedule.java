package com.sofka.domain.mission;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;

import java.util.Objects;

public class Schedule extends Entity<ScheduleID> {
    private Operation operation;

    private StartDate startDate;

    private EndDate endDate;
    public Schedule(ScheduleID entityId, Operation operation, StartDate startDate, EndDate endDate) {
        super(entityId);
        this.operation = operation;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public void UpdateOperation(Operation operation){this.operation = Objects.requireNonNull(operation);
    }

    public void UpdateStartDate(StartDate startDate){
        this.startDate = Objects.requireNonNull(startDate);
    }

    public void UpdateEndDate(EndDate endDate){
        this.endDate = Objects.requireNonNull(endDate);
    }

    public Operation operation() {
        return operation;
    }

    public StartDate startDate() {
        return startDate;
    }
    public EndDate endDate() {
        return endDate;
    }
}
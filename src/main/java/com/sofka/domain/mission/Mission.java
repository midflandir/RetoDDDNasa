package com.sofka.domain.mission;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.mission.events.EngineerChargeChanged;
import com.sofka.domain.mission.events.EngineerSalaryIncreased;
import com.sofka.domain.mission.events.EngineerSalaryReduced;
import com.sofka.domain.mission.events.Engineeradded;
import com.sofka.domain.mission.events.ExplorationSystemCategoryChanged;
import com.sofka.domain.mission.events.ExplorationSystemModelUpdated;
import com.sofka.domain.mission.events.ExplorationSystemVersionChanged;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.events.MissionStatusUpdated;
import com.sofka.domain.mission.events.MissionnameUpdated;
import com.sofka.domain.mission.events.ScheduleEndDateUpdated;
import com.sofka.domain.mission.events.ScheduleOpertaionUpdated;
import com.sofka.domain.mission.events.ScheduleStartDateUpdated;
import com.sofka.domain.mission.events.Scheduleadded;
import com.sofka.domain.mission.events.Systemadded;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;
import com.sofka.domain.mission.values.Salary;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Mission extends AggregateEvent<MissionID>{

    protected MissionName missionName;

    protected MissionStatus missionStatus;
    protected Set<Engineer> engineers;
    protected Set<Schedule> schedules;
    protected Set<ExplorationSystem> explorationSystems;

    public Mission(MissionID entityId, MissionName missionName, MissionStatus missionStatus) {
        super(entityId);
        appendChange(new MissionCreated(missionName, missionStatus)).apply();
        subscribe(new MissionChange(this));
    }
    public Mission(MissionID entityId) {
        super(entityId);
        subscribe(new MissionChange(this));
    }

    public static Mission from(MissionID missionID, List<DomainEvent> events){
        var mission = new Mission(missionID);
        events.forEach(mission::applyEvent);
        return mission;
    }
    public void Updatemissionname(MissionName missionName){
        Objects.requireNonNull(missionName);
        appendChange(new MissionnameUpdated(missionName)).apply();
    }

    public void Updatemissionstatus(MissionStatus missionStatus){
        Objects.requireNonNull(missionStatus);
        appendChange(new MissionStatusUpdated(missionStatus)).apply();
    }

    public void AddEngineer(EngineerID entityId, EngineerName engineerName, Charge charge, Salary salary){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(engineerName);
        Objects.requireNonNull(charge);
        Objects.requireNonNull(salary);
        appendChange(new Engineeradded(entityId, engineerName, charge, salary)).apply();
    }


    public void AddSchedule(ScheduleID entityId, Operation operation, StartDate startDate, EndDate endDate){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(operation);
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);
        appendChange(new Scheduleadded(entityId, operation, startDate, endDate)).apply();
    }


    public void AddSystem(ExplorationSystemID entityId, Model model, Category category, Version version){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(model);
        Objects.requireNonNull(category);
        Objects.requireNonNull(version);
        appendChange(new Systemadded(entityId, model, category, version)).apply();
    }


    public void ChangeEngineerCharge(EngineerID entityId, Charge charge){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(charge);
        appendChange(new EngineerChargeChanged(entityId, charge)).apply();
    }


    public void IncreaseEngineerSalary(EngineerID entityId, Salary salary){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(salary);
        appendChange(new EngineerSalaryIncreased(entityId, salary)).apply();
    }


    public void ReduceEngineerSalary(EngineerID entityId,Salary salary){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(salary);
        appendChange(new EngineerSalaryReduced(entityId, salary)).apply();
    }


    public void UpdateScheduleOperation(ScheduleID entityId, Operation operation){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(operation);
        appendChange(new ScheduleOpertaionUpdated(entityId, operation)).apply();
    }


    public void UpdateScheduleStartDate(ScheduleID entityId, StartDate startDate){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(startDate);
        appendChange(new ScheduleStartDateUpdated(entityId, startDate)).apply();
    }


    public void UpdateScheduleEndDate(ScheduleID entityId, EndDate endDate){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(endDate);
        appendChange(new ScheduleEndDateUpdated(entityId, endDate)).apply();
    }


    public void UpdateExplorationSystemModel(ExplorationSystemID entityId, Model model){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(model);
        appendChange(new ExplorationSystemModelUpdated(entityId, model)).apply();
    }


    public void ChangeExplorationSystemCategory(ExplorationSystemID entityId, Category category){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(category);
        appendChange(new ExplorationSystemCategoryChanged(entityId, category)).apply();
    }


    public void ChangeExplorationSystemVersion(ExplorationSystemID entityId, Version version){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(version);
        appendChange(new ExplorationSystemVersionChanged(entityId, version)).apply();
    }

    public Optional<Engineer> getEngineerById(EngineerID entityID){
        return engineers().stream().filter((engineer -> engineer.identity().equals(entityID))).findFirst();
    }

    public Optional<Schedule> getScheduleById(ScheduleID entityID){
        return schedules().stream().filter((engineer -> engineer.identity().equals(entityID))).findFirst();
    }

    public Optional<ExplorationSystem> getExplorationSystemById(ExplorationSystemID entityID){
        return explorationSystems().stream().filter((explorationSystem -> explorationSystem.identity().equals(entityID))).findFirst();
    }
    public MissionName MissionName() {
        return missionName;
    }

    public MissionStatus MissionStatus() {
        return missionStatus;
    }
    public Set<Engineer> engineers() {
        return engineers;
    }

    public Set<Schedule> schedules() {
        return schedules;
    }

    public Set<ExplorationSystem> explorationSystems() {
        return explorationSystems;
    }
}

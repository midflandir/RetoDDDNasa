package com.sofka.domain.mission;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.mission.events.EngineerChargeChanged;
import com.sofka.domain.mission.events.EngineerSalaryIncreased;
import com.sofka.domain.mission.events.EngineerSalaryReduced;
import com.sofka.domain.mission.events.Engineeradded;
import com.sofka.domain.mission.events.ExplorationSystemCategoryChanged;
import com.sofka.domain.mission.events.ExplorationSystemModelUpdated;
import com.sofka.domain.mission.events.ExplorationSystemVersionChanged;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.events.MissionnameUpdated;
import com.sofka.domain.mission.events.ScheduleEndDateUpdated;
import com.sofka.domain.mission.events.ScheduleOpertaionUpdated;
import com.sofka.domain.mission.events.ScheduleStartDateUpdated;
import com.sofka.domain.mission.events.Scheduleadded;
import com.sofka.domain.mission.events.Systemadded;

import java.util.HashSet;

public class MissionChange  extends EventChange {
    public MissionChange(Mission mission){
        apply((MissionCreated event) ->{
            mission.missionName = event.getName();
            mission.engineers = new HashSet<>();
            mission.explorationSystems = new HashSet<>();
            mission.schedules = new HashSet<>();
        });

        apply((MissionnameUpdated event)->{
            mission.missionName = event.getMissionName();
        });

        apply((Engineeradded event)->{
            mission.engineers.add(new Engineer(
                    event.getEntityId(),
                    event.getEngineerName(),
                    event.getCharge(),
                    event.getSalary()
            ));
        });
        apply((Scheduleadded event)->{

            mission.schedules.add(new Schedule(
                    event.getEntityId(),
                    event.getOperation(),
                    event.getStartDate(),
                    event.getEndDate()
            ));
        });
        apply((Systemadded event)->{

            mission.explorationSystems.add(new ExplorationSystem(
                    event.getEntityId(),
                    event.getModel(),
                    event.getCategory(),
                    event.getVersion()
            ));
        });

        apply((EngineerChargeChanged event)->{
            var engineer = mission.getEngineerById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            engineer.ChangeEngineerCharge(event.getCharge());
        });

        apply((EngineerSalaryIncreased event)->{
            var engineer = mission.getEngineerById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            engineer.IncreaseSalary(event.getSalary());
        });

        apply((EngineerSalaryReduced event)->{
            var engineer = mission.getEngineerById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            engineer.ReduceSalary(event.getSalary());
        });

        apply((ScheduleOpertaionUpdated event)->{
            var schedule = mission.getScheduleById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            schedule.UpdateOperation(event.getOperation());
        });

        apply((ScheduleStartDateUpdated event)->{
            var schedule = mission.getScheduleById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            schedule.UpdateStartDate(event.getStartDate());
        });

        apply((ScheduleEndDateUpdated event)->{
            var schedule = mission.getScheduleById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            schedule.UpdateEndDate(event.getEndDate());
        });

        apply((ExplorationSystemModelUpdated event)->{
            var explorationSystem = mission.getExplorationSystemById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            explorationSystem.UpdateModel(event.getModel());
        });

        apply((ExplorationSystemCategoryChanged event)->{
            var explorationSystem = mission.getExplorationSystemById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            explorationSystem.ChangeCategory(event.getCategory());
        });

        apply((ExplorationSystemVersionChanged event)->{
            var explorationSystem = mission.getExplorationSystemById(event.getEntityId()).orElseThrow(()->
                    new IllegalArgumentException("Wrong id to reach the Entity"));
            explorationSystem.ChangeVersion(event.getVersion());
        });

    }





}

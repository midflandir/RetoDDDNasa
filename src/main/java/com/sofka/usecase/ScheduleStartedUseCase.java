package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleStartedUseCase extends UseCase<TriggeredEvent<MissionCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<MissionCreated> missionCreatedTriggeredEvent) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        MissionCreated event = missionCreatedTriggeredEvent.getDomainEvent();
        Mission mission = Mission.from(MissionID.of(event.aggregateRootId()), this.retrieveEvents());
        ScheduleID incomeAccountID = new ScheduleID();
        Operation operation = new Operation( "Mission " + event.getName().value() + " Started");
        StartDate startDate = new StartDate(dateFormat.format(date));
        EndDate endDate = new EndDate("Undefined");
        mission.AddSchedule(incomeAccountID, operation, startDate, endDate);
        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}

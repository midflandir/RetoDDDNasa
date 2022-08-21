package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.events.Systemadded;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionStatus;

public class MissionStartedUseCase extends UseCase<TriggeredEvent<Systemadded>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<Systemadded> systemAddedTriggeredEvent) {

        Systemadded event = systemAddedTriggeredEvent.getDomainEvent();
        Mission mission = Mission.from(MissionID.of(event.aggregateRootId()), this.retrieveEvents());
        mission.Updatemissionstatus(new MissionStatus( "In Development"));
        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}

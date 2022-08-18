package com.sofka.domain.mission;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;

import java.util.List;
import java.util.Set;

public class Mission extends AggregateEvent<MissionID>{

    protected MissionName missionName;
    protected Set<Engineer> engineers;
    protected Set<Schedule> schedules;
    protected Set<ExplorationSystem> explorationSystems;

    public Mission(MissionID entityId, MissionName missionName) {
        super(entityId);
        appendChange(new MissionCreated(missionName)).apply();
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


}

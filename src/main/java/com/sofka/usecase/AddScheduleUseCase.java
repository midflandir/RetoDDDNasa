package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.commands.AddSchedule;

public class AddScheduleUseCase extends UseCase<RequestCommand<AddSchedule>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddSchedule> requestCommand) {
        var command = requestCommand.getCommand();
        var mission = Mission.from(command.getMissionID(), retrieveEvents(command.getMissionID().value()));
        mission.AddSchedule(command.getEntityId(),
                command.getOperation(),
                command.getStartDate(),
                command.getEndDate());

        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}

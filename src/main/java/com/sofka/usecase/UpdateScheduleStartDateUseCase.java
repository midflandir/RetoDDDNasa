package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.commands.UpdateScheduleStartDate;

public class UpdateScheduleStartDateUseCase extends UseCase<RequestCommand<UpdateScheduleStartDate>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateScheduleStartDate> RequestCommand) {
        var command = RequestCommand.getCommand();
        var mission = Mission.from(command.getMissionID(), retrieveEvents(command.getMissionID().value()));
        mission.UpdateScheduleStartDate(command.getEntityId(), command.getStartDate());
        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}
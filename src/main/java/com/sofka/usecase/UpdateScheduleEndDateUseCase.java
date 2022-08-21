package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.commands.UpdateScheduleEndDate;

public class UpdateScheduleEndDateUseCase  extends UseCase<RequestCommand<UpdateScheduleEndDate>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateScheduleEndDate> RequestCommand) {
        var command = RequestCommand.getCommand();
        var mission = Mission.from(command.getMissionID(), retrieveEvents(command.getMissionID().value()));
        mission.UpdateScheduleEndDate(command.getEntityId(), command.getEndDate());
        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}
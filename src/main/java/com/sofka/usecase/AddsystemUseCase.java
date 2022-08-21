package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.commands.AddSystem;

public class AddsystemUseCase extends UseCase<RequestCommand<AddSystem>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddSystem> requestCommand) {
        var command = requestCommand.getCommand();
        var mission = Mission.from(command.getMissionID(), retrieveEvents(command.getMissionID().value()));
        mission.AddSystem(command.getEntityId(),
                command.getModel(),
                command.getCategory(),
                command.getVersion());

        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}

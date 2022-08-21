package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.commands.AddEngineer;

public class AddEngineerUseCase extends UseCase<RequestCommand<AddEngineer>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddEngineer> addEngineerRequestCommand) {
        var command = addEngineerRequestCommand.getCommand();
        var mission = Mission.from(command.getMissionID(), retrieveEvents(command.getMissionID().value()));
        mission.AddEngineer(command.getEntityId(),
                command.getEngineerName(),
                command.getCharge(),
                command.getSalary());


        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}

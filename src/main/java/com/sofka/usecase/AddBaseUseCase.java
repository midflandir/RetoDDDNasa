package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.launchsystem.LaunchSystem;
import com.sofka.domain.launchsystem.commands.AddBase;

public class AddBaseUseCase extends UseCase<RequestCommand<AddBase>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddBase> requestCommand) {
        var command = requestCommand.getCommand();
        var launchSystem = LaunchSystem.from(command.getLaunchSystemID(), retrieveEvents(command.getLaunchSystemID().value()));
        launchSystem.AddBase(command.getEntityId(),
                command.getBaseName(),
                command.getPlataform(),
                command.getPropetary(),
                command.getLocation());

        emit().onResponse(new ResponseEvents(launchSystem.getUncommittedChanges()));
    }
}

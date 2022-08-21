package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.launchsystem.LaunchSystem;
import com.sofka.domain.launchsystem.commands.AddOperator;

public class AddOperatorUseCase extends UseCase<RequestCommand<AddOperator>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddOperator> requestCommand) {
        var command = requestCommand.getCommand();
        var launchSystem = LaunchSystem.from(command.getLaunchSystemID(), retrieveEvents(command.getLaunchSystemID().value()));
        launchSystem.AddOperator(command.getEntityId(),
                command.getOperatorName(),
                command.getType());

        emit().onResponse(new ResponseEvents(launchSystem.getUncommittedChanges()));
    }
}

package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.launchsystem.LaunchSystem;
import com.sofka.domain.launchsystem.commands.CreateLaunchSystem;

public class CreateLaunchSystemUseCase extends UseCase<RequestCommand<CreateLaunchSystem>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateLaunchSystem> createMissionRequestCommand) {
        CreateLaunchSystem command = createMissionRequestCommand.getCommand();
        LaunchSystem launchSystem = new LaunchSystem(
                command.getLaunchSystemID(),
                command.getLaunchDate()
        );
        emit().onResponse(new ResponseEvents(launchSystem.getUncommittedChanges()));
    }
}

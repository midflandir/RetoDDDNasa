package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.commands.CreateMission;

public class CreateMissionUseCase extends UseCase<RequestCommand<CreateMission>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateMission> createMissionRequestCommand) {
        var command = createMissionRequestCommand.getCommand();
        var game = new Mission(
                command.getMissionID(),
                command.getMissionName()
        );
        emit().onResponse(new ResponseEvents(game.getUncommittedChanges()));
    }
}

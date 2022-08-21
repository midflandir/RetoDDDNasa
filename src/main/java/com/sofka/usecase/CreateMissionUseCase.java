package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.mission.Mission;
import com.sofka.domain.mission.commands.CreateMission;

public class CreateMissionUseCase extends UseCase<RequestCommand<CreateMission>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateMission> createMissionRequestCommand) {
        CreateMission command = createMissionRequestCommand.getCommand();
        Mission mission = new Mission(
                command.getMissionID(),
                command.getMissionName(),
                command.getMissionStatus()
        );
        emit().onResponse(new ResponseEvents(mission.getUncommittedChanges()));
    }
}

package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofka.domain.launchsystem.LaunchSystem;
import com.sofka.domain.launchsystem.commands.AddLaunchVehicle;

public class AddLaunchVehicleUseCase extends UseCase<RequestCommand<AddLaunchVehicle>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddLaunchVehicle> requestCommand) {
        var command = requestCommand.getCommand();
        var launchsystem = LaunchSystem.from(command.getLaunchSystemID(), retrieveEvents(command.getLaunchSystemID().value()));
        launchsystem.AddLaunchVehicle(command.getEntityId(),
                command.getModel(),
                command.getManufacturer(),
                command.getThrust(),
                command.getVersion());

        emit().onResponse(new ResponseEvents(launchsystem.getUncommittedChanges()));
    }

}
package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.launchsystem.commands.CreateLaunchSystem;
import com.sofka.domain.launchsystem.events.LaunchSystemCreated;
import com.sofka.domain.launchsystem.values.LaunchDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateLaunchSystemUseCaseTest {


    @Test
    void CreateLaunchSystemUseCaseTest() {

        CreateLaunchSystem command = new CreateLaunchSystem(new LaunchDate("2022-07-03"));
        CreateLaunchSystemUseCase  useCase = new CreateLaunchSystemUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the launchsystem"))
                .getDomainEvents();
        LaunchSystemCreated event = (LaunchSystemCreated) events.get(0);

        Assertions.assertEquals(command.getLaunchDate().value(), event.getLaunchDate().value());
    }
}
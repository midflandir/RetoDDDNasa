package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.mission.commands.CreateMission;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.values.MissionName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class CreateMissionUseCaseTest {

    @Test
    void CreateMisionUseCaseTest() {

        CreateMission command = new CreateMission(new MissionName("Curiosity"));
        CreateMissionUseCase  useCase = new CreateMissionUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Something went wrong creating the mision"))
                .getDomainEvents();
        MissionCreated event = (MissionCreated) events.get(0);

        Assertions.assertEquals(command.getMissionName().value(), event.getName().value());
    }
}
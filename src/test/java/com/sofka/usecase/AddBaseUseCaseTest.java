package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.launchsystem.commands.AddBase;
import com.sofka.domain.launchsystem.commands.CreateLaunchSystem;
import com.sofka.domain.launchsystem.events.Baseadded;
import com.sofka.domain.launchsystem.events.LaunchSystemCreated;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.LaunchDate;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.Location;
import com.sofka.domain.launchsystem.values.Plataform;
import com.sofka.domain.launchsystem.values.Propetary;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.values.MissionID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddBaseUseCaseTest {

    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddBaseUseCaseTest(){


        LaunchSystemCreated event = new LaunchSystemCreated(new LaunchDate("2022-07-03"));
        event.setAggregateRootId(ROOT_ID);

        AddBase command = new AddBase(new LaunchSystemID(event.aggregateRootId()),
                new BaseID(),
                new BaseName("Cape"),
                new Plataform("39A"),
                new Propetary("ULA"),
                new Location("Cape North"));
        var useCase = new AddBaseUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Baseadded responseEvent = (Baseadded) events.get(0);

        Assertions.assertEquals(responseEvent.getBasename(), command.getBaseName());
        Assertions.assertEquals(responseEvent.getPlataform(), command.getPlataform());
        Assertions.assertEquals(responseEvent.getPropetary(), command.getPropetary());
        Assertions.assertEquals(responseEvent.getLocation(), command.getLocation());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}
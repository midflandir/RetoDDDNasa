package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.mission.commands.AddSystem;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.events.Systemadded;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddsystemUseCaseTest {


    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddsystemUseCaseTest(){


        MissionCreated event = new MissionCreated(new MissionName("Curiosity"));
        event.setAggregateRootId(ROOT_ID);

        AddSystem command = new AddSystem(new MissionID(event.aggregateRootId()),
                new ExplorationSystemID(),
                new Model("Rober"),
                new Category("Surface Exploration"),
                new Version("M 2.03"));
        var useCase = new AddsystemUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Systemadded responseEvent = (Systemadded) events.get(0);

        Assertions.assertEquals(responseEvent.getVersion(), command.getVersion());
        Assertions.assertEquals(responseEvent.getCategory(), command.getCategory());
        Assertions.assertEquals(responseEvent.getModel(), command.getModel());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}
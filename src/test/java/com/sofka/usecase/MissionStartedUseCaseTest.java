package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.events.MissionStatusUpdated;
import com.sofka.domain.mission.events.Systemadded;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
@ExtendWith(MockitoExtension.class)
class MissionStartedUseCaseTest {

    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void assignIncomeAccountTest(){

        Systemadded event = new Systemadded( new ExplorationSystemID(),
                new Model("Rober"),
                new Category("Surface Exploration"),
                new Version("M 2.03"));
        event.setAggregateRootId(ROOT_ID);
        var useCase = new MissionStartedUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new MissionCreated(new MissionName("Curiosity"), new MissionStatus("Pending")),
                event
        ));
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        MissionStatusUpdated responseEvent = (MissionStatusUpdated) events.get(0);

        Assertions.assertEquals(responseEvent.getMissionStatus().value(), "In Development");
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}
package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.events.Scheduleadded;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ScheduleStartedUseCaseTest {

    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void assignIncomeAccountTest(){
        // Arrange
        MissionCreated event = new MissionCreated(new MissionName("Curiosity"), new MissionStatus("Pending"));
        event.setAggregateRootId(ROOT_ID);
        var useCase = new ScheduleStartedUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        Scheduleadded responseEvent = (Scheduleadded) events.get(0);

        //Assert

        Assertions.assertEquals(responseEvent.getOperation().value(), "Mission Curiosity Started");
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }

}
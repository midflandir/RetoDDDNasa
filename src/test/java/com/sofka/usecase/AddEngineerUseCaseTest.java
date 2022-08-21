package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.mission.commands.AddEngineer;
import com.sofka.domain.mission.events.Engineeradded;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.Salary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddEngineerUseCaseTest {


    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddEngineerUseCaseTest(){


        MissionCreated event = new MissionCreated(new MissionName("Curiosity"));
        event.setAggregateRootId(ROOT_ID);

        AddEngineer command = new AddEngineer(new MissionID(event.aggregateRootId()),
                new EngineerID(),
                new EngineerName("Alejandro Giraldo"),
                new Charge("Developer"),
                new Salary("1230000USD"));
        var useCase = new AddEngineerUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Engineeradded responseEvent = (Engineeradded) events.get(0);

        Assertions.assertEquals(responseEvent.getEngineerName(), command.getEngineerName());
        Assertions.assertEquals(responseEvent.getCharge(), command.getCharge());
        Assertions.assertEquals(responseEvent.getSalary(), command.getSalary());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}
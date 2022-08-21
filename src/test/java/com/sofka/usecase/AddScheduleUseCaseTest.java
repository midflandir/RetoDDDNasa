package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.mission.commands.AddEngineer;
import com.sofka.domain.mission.commands.AddSchedule;
import com.sofka.domain.mission.events.Engineeradded;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.events.Scheduleadded;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.Salary;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AddScheduleUseCaseTest {


    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddScheduleUseCaseTest(){


        MissionCreated event = new MissionCreated(new MissionName("Curiosity"));
        event.setAggregateRootId(ROOT_ID);

        AddSchedule command = new AddSchedule(new MissionID(event.aggregateRootId()),
                new ScheduleID(),
                new Operation("Qsat deployment"),
                new StartDate("2022-08-08 12:33"),
                new EndDate("2022-08-08 15:12"));
        var useCase = new AddScheduleUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Scheduleadded responseEvent = (Scheduleadded) events.get(0);

        Assertions.assertEquals(responseEvent.getOperation(), command.getOperation());
        Assertions.assertEquals(responseEvent.getStartDate(), command.getStartDate());
        Assertions.assertEquals(responseEvent.getEndDate(), command.getEndDate());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}
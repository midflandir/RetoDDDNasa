package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.mission.commands.UpdateScheduleStartDate;
import com.sofka.domain.mission.events.MissionCreated;
import com.sofka.domain.mission.events.ScheduleStartDateUpdated;
import com.sofka.domain.mission.events.Scheduleadded;
import com.sofka.domain.mission.values.EndDate;
import com.sofka.domain.mission.values.MissionID;
import com.sofka.domain.mission.values.MissionName;
import com.sofka.domain.mission.values.MissionStatus;
import com.sofka.domain.mission.values.Operation;
import com.sofka.domain.mission.values.ScheduleID;
import com.sofka.domain.mission.values.StartDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
@ExtendWith(MockitoExtension.class)
class UpdateScheduleStartDateUseCaseTest {

    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdateScheduleStartDateUseCaseTest(){

        UpdateScheduleStartDate command = new UpdateScheduleStartDate(new MissionID(ROOT_ID),
                new ScheduleID("123"),
                new StartDate("3045-09-09 05:07"));
        var useCase = new UpdateScheduleStartDateUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(
                new MissionCreated(new MissionName("Curiosity"), new MissionStatus("Pending")),
                new Scheduleadded(new ScheduleID("123"),
                        new Operation("Qsat deployment"),
                        new StartDate("2022-08-08 12:33"),
                        new EndDate("2022-08-08 15:12"))
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        ScheduleStartDateUpdated responseEvent = (ScheduleStartDateUpdated) events.get(0);

        Assertions.assertEquals(responseEvent.getStartDate(), command.getStartDate());

        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}
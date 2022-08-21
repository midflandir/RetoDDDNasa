package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.commands.AddLaunchVehicle;
import com.sofka.domain.launchsystem.commands.AddOperator;
import com.sofka.domain.launchsystem.events.LaunchSystemCreated;
import com.sofka.domain.launchsystem.events.LaunchVehicleAdded;
import com.sofka.domain.launchsystem.events.Operatoradded;
import com.sofka.domain.launchsystem.values.LaunchDate;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Manufacturer;
import com.sofka.domain.launchsystem.values.OperatorID;
import com.sofka.domain.launchsystem.values.OperatorName;
import com.sofka.domain.launchsystem.values.OperatorType;
import com.sofka.domain.launchsystem.values.Thrust;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AddOperatorUseCaseTest {

    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddOperatorUseCaseTest(){


        LaunchSystemCreated event = new LaunchSystemCreated(new LaunchDate("2022-07-03"));
        event.setAggregateRootId(ROOT_ID);

        AddOperator command = new AddOperator(new LaunchSystemID(event.aggregateRootId()),
                new OperatorID(),
                new OperatorName("ESA"),
                new OperatorType("Extern"));
        var useCase = new AddOperatorUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        Operatoradded responseEvent = (Operatoradded) events.get(0);

        Assertions.assertEquals(responseEvent.getOperatorName(), command.getOperatorName());
        Assertions.assertEquals(responseEvent.getOperatorType(), command.getType());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}
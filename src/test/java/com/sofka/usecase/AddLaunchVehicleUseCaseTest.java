package com.sofka.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.commands.AddBase;
import com.sofka.domain.launchsystem.commands.AddLaunchVehicle;
import com.sofka.domain.launchsystem.events.Baseadded;
import com.sofka.domain.launchsystem.events.LaunchSystemCreated;
import com.sofka.domain.launchsystem.events.LaunchVehicleAdded;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.BaseName;
import com.sofka.domain.launchsystem.values.LaunchDate;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.LaunchVehicleID;
import com.sofka.domain.launchsystem.values.Location;
import com.sofka.domain.launchsystem.values.Manufacturer;
import com.sofka.domain.launchsystem.values.Plataform;
import com.sofka.domain.launchsystem.values.Propetary;
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
class AddLaunchVehicleUseCaseTest {

    private final String ROOT_ID = "123456789";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddLaunchVehicleUseCaseTest(){


        LaunchSystemCreated event = new LaunchSystemCreated(new LaunchDate("2022-07-03"));
        event.setAggregateRootId(ROOT_ID);

        AddLaunchVehicle command = new AddLaunchVehicle(new LaunchSystemID(event.aggregateRootId()),
                new LaunchVehicleID(),
                new Model("Buran"),
                new Manufacturer("Roscosmos"),
                new Thrust("345456T"),
                new Version("Block 5.2"));
        var useCase = new AddLaunchVehicleUseCase();
        Mockito.when(repository.getEventsBy(ROOT_ID)).thenReturn(List.of(event));
        useCase.addRepository(repository);


        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOT_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        LaunchVehicleAdded responseEvent = (LaunchVehicleAdded) events.get(0);

        Assertions.assertEquals(responseEvent.getModel(), command.getModel());
        Assertions.assertEquals(responseEvent.getManufacturer(), command.getManufacturer());
        Assertions.assertEquals(responseEvent.getThrust(), command.getThrust());
        Assertions.assertEquals(responseEvent.getVersion(), command.getVersion());
        Mockito.verify(repository).getEventsBy(ROOT_ID);

    }
}
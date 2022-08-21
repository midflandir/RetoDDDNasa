package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.BaseID;
import com.sofka.domain.launchsystem.values.LaunchDate;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.launchsystem.values.Propetary;

public class LaunchDateUpdated extends DomainEvent {

    private final LaunchDate launchDate;

    public LaunchDateUpdated(LaunchDate launchDate) {
        super("com.sofka.domain.launchsystem.event.LaunchDateUpdated");
        this.launchDate = launchDate;
    }

    public LaunchDate getLaunchDate() {
        return launchDate;
    }
}

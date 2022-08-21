package com.sofka.domain.launchsystem.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.launchsystem.values.LaunchDate;

public class LaunchSystemCreated extends DomainEvent {
    private final LaunchDate launchDate;

    public LaunchSystemCreated(LaunchDate launchDate) {
        super("com.sofka.domain.LaunchSystem.event.LaunchSystemCreated");
        this.launchDate = launchDate;
    }

    public LaunchDate getLaunchDate() {
        return launchDate;
    }
}

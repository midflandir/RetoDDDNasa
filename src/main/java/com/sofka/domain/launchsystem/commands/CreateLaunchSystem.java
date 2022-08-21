package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.LaunchDate;
import com.sofka.domain.launchsystem.values.LaunchSystemID;

public class CreateLaunchSystem extends Command {
    private final LaunchSystemID launchSystemID;
    private final LaunchDate launchDate;

    public CreateLaunchSystem(LaunchDate launchDate) {
        this.launchSystemID = new LaunchSystemID();
        this.launchDate = launchDate;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public LaunchDate getLaunchDate() {
        return launchDate;
    }
}

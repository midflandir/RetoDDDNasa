package com.sofka.domain.launchsystem.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.launchsystem.values.LaunchDate;
import com.sofka.domain.launchsystem.values.LaunchSystemID;

public class UpdateLaunchDate extends Command {

    private final LaunchSystemID launchSystemID;
    private final LaunchDate launchDate;

    public UpdateLaunchDate(LaunchSystemID launchSystemID, LaunchDate launchDate) {
        this.launchSystemID = launchSystemID;
        this.launchDate = launchDate;
    }

    public LaunchSystemID getLaunchSystemID() {
        return launchSystemID;
    }

    public LaunchDate getLaunchDate() {
        return launchDate;
    }
}

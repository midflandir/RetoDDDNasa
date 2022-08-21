package com.sofka.domain.mission.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.generic.values.Version;
import com.sofka.domain.launchsystem.values.LaunchSystemID;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.EngineerName;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.mission.values.Salary;

public class Systemadded extends DomainEvent {

    private final ExplorationSystemID entityId;

    private final Model model;

    private final Category category;

    private final Version version;

    public Systemadded(ExplorationSystemID entityId, Model model, Category category, Version version) {
        super("com.sofka.domain.mission.event.Systemadded");
        this.entityId = entityId;
        this.model = model;
        this.category = category;
        this.version = version;
    }

    public ExplorationSystemID getEntityId() {
        return entityId;
    }

    public Model getModel() {
        return model;
    }

    public Category getCategory() {
        return category;
    }

    public Version getVersion() {
        return version;
    }
}

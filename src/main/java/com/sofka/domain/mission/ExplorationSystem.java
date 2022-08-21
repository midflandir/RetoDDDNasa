package com.sofka.domain.mission;

import co.com.sofka.domain.generic.Entity;
import com.sofka.domain.mission.values.ExplorationSystemID;
import com.sofka.domain.generic.values.Model;
import com.sofka.domain.mission.values.Category;
import com.sofka.domain.generic.values.Version;

import java.util.Objects;

public class ExplorationSystem extends Entity<ExplorationSystemID> {
    private Model model;

    private Category category;

    private Version version;
    public ExplorationSystem(ExplorationSystemID entityId, Model model, Category category, Version version) {
        super(entityId);
        this.model = model;
        this.category = category;
        this.version = version;
    }


    public void UpdateModel( Model model){
        this.model = Objects.requireNonNull(model);
    }

    public void ChangeCategory(Category category){
        this.category = Objects.requireNonNull(category);
    }

    public void ChangeVersion(Version version){
        this.version = Objects.requireNonNull(version);
    }

    public Model engineerName() {
        return model;
    }

    public Category charge() {
        return category;
    }
    public Version salary() {
        return version;
    }
}

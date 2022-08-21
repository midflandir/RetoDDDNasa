package com.sofka.domain.mission.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.domain.mission.values.Charge;
import com.sofka.domain.mission.values.EngineerID;
import com.sofka.domain.mission.values.MissionID;

public class ChangeEngineerCharge extends Command {
    private final MissionID missionID;
    private final EngineerID entityId;
    private final Charge charge;

    public ChangeEngineerCharge(MissionID missionID, EngineerID entityId, Charge charge) {
        this.missionID = missionID;
        this.entityId = entityId;
        this.charge = charge;
    }

    public MissionID getMissionID() {
        return missionID;
    }

    public EngineerID getEntityId() {
        return entityId;
    }

    public Charge getCharge() {
        return charge;
    }
}

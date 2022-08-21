package com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofka.domain.launchsystem.LaunchSystem;
import com.sofka.domain.launchsystem.events.LaunchDateUpdated;
import com.sofka.domain.launchsystem.values.LaunchSystemID;

public class UpdateLaunchSystemDate extends UseCase<TriggeredEvent<LaunchDateUpdated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<LaunchDateUpdated> accountCreatedTriggeredEvent) {

     /*   LaunchDateUpdated event = accountCreatedTriggeredEvent.getDomainEvent();
        LaunchSystem account = LaunchSystem.from(LaunchSystemID.of(event.aggregateRootId()), this.retrieveEvents());
        IncomeAccountID incomeAccountID = new IncomeAccountID();
        AccountName name = new AccountName(event.getName().value() + ".Income");
        Balance balance = new Balance(0);
        account.assignIncomeAccount(incomeAccountID, name, balance);
        emit().onResponse(new ResponseEvents(account.getUncommittedChanges()));*/
    }
}

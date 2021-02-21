package com.example.workflow.serviceDelegates;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("determineInitiatorService")
public class DetermineInitiatorGroups implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<User> queriedUsers = delegateExecution.getProcessEngineServices()
                .getIdentityService()
                .createUserQuery()
                .memberOfGroup("gMitarbeiter")
                .list();

        IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
        String initiator = (String) delegateExecution.getVariableTyped("procInitUser").getValue();
        delegateExecution.setVariable("verwaltungIsInitiator", false);
        for (Group group : identityService.createGroupQuery().groupMember(initiator).list()) {
            if (group.getId().equals("gVerwaltung")) {
                delegateExecution.setVariable("verwaltungIsInitiator", true);
            }
        }
    }
}

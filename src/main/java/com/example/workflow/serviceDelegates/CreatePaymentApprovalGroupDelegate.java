package com.example.workflow.serviceDelegates;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.Group;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("createPaymentApprovalGroupService")
public class CreatePaymentApprovalGroupDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        //Retrieve users which are allowed to release payments
        List<User> candidateUsers = new LinkedList<User>();
        for (String groupId : new String[] { "gVerwaltung", "gVorstandFinanzen" }) {
            List<User> groupUsers = delegateExecution.getProcessEngineServices()
                    .getIdentityService()
                    .createUserQuery()
                    .memberOfGroup(groupId)
                    .list();
            candidateUsers.addAll(groupUsers);
        }
        //Remove the initiating user
        candidateUsers.removeIf(user ->
                user.getId().equals((String) delegateExecution.getVariable("paymentInitiator")));

        //Create group for allowed reviewers
        IdentityService identityService = Context.getProcessEngineConfiguration().getIdentityService();
        final String groupId = "r"+delegateExecution.getProcessInstanceId().replace("-", "");
        Group paymentReviewGroup = identityService.newGroup(groupId);
        paymentReviewGroup.setName("Zahlungsfreigabe Rechnung: " + delegateExecution.getProcessInstanceId());
        identityService.saveGroup(paymentReviewGroup);

        //Add possible to created group
        for (User user: candidateUsers) {
            identityService.createMembership(user.getId(), groupId);
        }

        delegateExecution.setVariable("paymentRevierGroupId", groupId);
    }
}

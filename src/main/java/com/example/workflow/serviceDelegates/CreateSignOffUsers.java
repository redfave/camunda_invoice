package com.example.workflow.serviceDelegates;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Service("createSignOffUsersService")
public class CreateSignOffUsers implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<User> queriedUsers = execution.getProcessEngineServices()
                .getIdentityService()
                .createUserQuery()
                .memberOfGroup("gMitarbeiter")
                .list();

        Map<String, String> userList = new HashMap<String, String>();
        for (User user: queriedUsers) {
            userList.put(user.getId(), user.getFirstName() + " " + user.getLastName());
        }

        ObjectValue userListDataValue = Variables.objectValue(userList)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                .create();

        execution.setVariable("signOffUsers", userListDataValue);
    }
}

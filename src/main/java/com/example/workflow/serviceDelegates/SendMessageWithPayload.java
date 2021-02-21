package com.example.workflow.serviceDelegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("sendMessageDelegate")
public class SendMessageWithPayload implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.getProcessEngineServices()
                .getRuntimeService()
                .createMessageCorrelation("Message_1lqhfpr")
                .setVariable("zahlungAnMA", execution.getVariable("zahlungAnMA"))
                .setVariable("terminueberweisungDate", execution.getVariable("terminueberweisungDate"))
                .setVariable("procId", execution.getProcessInstanceId())
                .correlate();
    }
}

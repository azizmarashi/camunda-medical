package com.example.workflow.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.task.IdentityLink;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Component
@Transactional
public class UserAssignment implements TaskListener {

    //TODO write repository and queries
//    @Autowired
//    private MedicalWorkflowDao medicalWorkflowDao;

    @Override
    public void notify(DelegateTask delegateTask) {

        Set<IdentityLink> candidates = delegateTask.getCandidates();
        if (candidates.size() == 1) {
            for (IdentityLink candidate : candidates) {
                String relatedGroup = candidate.getGroupId();
                if (StringUtils.isNotEmpty(relatedGroup)) {
                    assignTaskToRelatedUser(relatedGroup, delegateTask);
                }
            }
        }
    }

    private void assignTaskToRelatedUser(String relatedGroup, DelegateTask delegateTask){

        String folderRequestNumber = delegateTask.getCaseExecution().getBusinessKey();
        delegateTask.setAssignee(findRelatedUsername(folderRequestNumber, relatedGroup));

    }

    /**
     According to this method, according to folderRequestNumber
     and business logic, the relevant user should be extracted
     from the database.
     */
    private String findRelatedUsername(String folderRequestNumber, String relatedGroup){
        return "demo";
    }

}
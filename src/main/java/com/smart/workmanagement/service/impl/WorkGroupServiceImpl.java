package com.smart.workmanagement.service.impl;


import com.smart.workmanagement.model.WorkGroup;
import com.smart.workmanagement.repo.WorkGroupRepo;
import com.smart.workmanagement.service.WorkGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkGroupServiceImpl implements WorkGroupService {

    private final WorkGroupRepo workGroupRepo;

    @Autowired
    public WorkGroupServiceImpl(WorkGroupRepo workGroupRepo) {
        this.workGroupRepo = workGroupRepo;
    }

    @Override
    public List<WorkGroup> getAllGroups() {
        List<WorkGroup> groups = workGroupRepo.findAll();
        log.info("IN getAll - {} groups found", groups.size());
        return groups;
    }

    @Override
    public WorkGroup findById(Long id) {
        WorkGroup result = workGroupRepo.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no group found by id: {}", id);
            return null;
        }
        log.info("IN findById - group found by id: {}", result);
        return result;
    }
}

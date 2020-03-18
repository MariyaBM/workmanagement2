package com.smart.workmanagement.service;

import com.smart.workmanagement.model.WorkGroup;

import java.util.List;

public interface WorkGroupService {

    List<WorkGroup> getAllGroups();

    WorkGroup findById(Long id);
}

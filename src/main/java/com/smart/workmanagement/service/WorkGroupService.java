package com.smart.workmanagement.service;

import com.smart.workmanagement.model.WorkGroup;

import java.util.List;

public interface WorkGroupService {

    List<WorkGroup> getAll();

    WorkGroup findById(Long id);
}

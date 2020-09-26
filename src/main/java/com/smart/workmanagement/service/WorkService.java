package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Work;

import java.util.List;

public interface WorkService {

    List<Work> getAllWork();

    Work getById(Long id);

    void create(Work work);

    void delete(Long id);

}

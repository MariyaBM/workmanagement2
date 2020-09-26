package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Status;
import com.smart.workmanagement.model.Work;
import com.smart.workmanagement.repo.WorkRepo;
import com.smart.workmanagement.service.WorkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class WorkServiceImpl implements WorkService {

    private final WorkRepo workRepo;

    @Autowired
    public WorkServiceImpl(WorkRepo workRepo) {
        this.workRepo = workRepo;
    }

    @Override
    public List<Work> getAllWork() {
        List<Work> works = workRepo.findAll();
        log.info("IN getAllWorks - {} works found", works.size());
        return works;
    }

    @Override
    public Work getById(Long id) {
        Work work = workRepo.findById(id).orElse(null);
        if (work == null) {
            log.warn("IN findById - no work found by id: {}", id);
            return null;
        }
        log.info("IN findById - work found by id: {}", work);
        return work;
    }

    @Override
    public void create(Work work) {
        work.setCreatedDate(LocalDateTime.now());
        work.setStatus(Status.ACTIVE);
        Work createdWork = workRepo.save(work);
        log.info("IN create - work: {} successfully registered", createdWork);

    }

    @Override
    public void delete(Long id) {
        Work work = workRepo.findById(id).orElse(null);
        if (work == null) {
            log.warn("IN findById - no work found by id: {}", id);
        } else {
            work.setStatus(Status.DELETED);
        }
        workRepo.deleteById(id);

    }
}

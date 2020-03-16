package com.smart.workmanagement.controller;


import com.smart.workmanagement.dto.WorkGroupDto;
import com.smart.workmanagement.model.WorkGroup;
import com.smart.workmanagement.service.WorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/work-group/")
public class WorkGroupController {

    private final WorkGroupService workGroupService;

    @Autowired
    public WorkGroupController(WorkGroupService workGroupService) {
        this.workGroupService = workGroupService;
    }

    @GetMapping
    public ResponseEntity<List<WorkGroupDto>> getAll() {
        List<WorkGroup> groups = workGroupService.getAll();

        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(WorkGroupDto.workGroupDtoList(groups), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<WorkGroupDto> getGroupById(@PathVariable(name = "id") Long id) {
        WorkGroup workGroup = workGroupService.findById(id);

        if (workGroup == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        WorkGroupDto workGroupDto = WorkGroupDto.fromWorkGroup(workGroup);

        return new ResponseEntity<>(workGroupDto, HttpStatus.OK);
    }
}

package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.WorkGroup;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkGroupDto {
    private Long id;
    private String groupList;

    public WorkGroup toWorkGroup() {
        WorkGroup group = new WorkGroup();
        group.setId(id);
        group.setGroupList(groupList);
        return group;
    }

    public static WorkGroupDto fromWorkGroup(WorkGroup group) {
        WorkGroupDto groupDto = new WorkGroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupList(group.getGroupList());
        return groupDto;
    }

    public static List<WorkGroupDto> workGroupDtoList(List<WorkGroup> groups) {
        List<WorkGroupDto> groupDtoList = new ArrayList<>();
        groups.forEach(group -> groupDtoList.add(fromWorkGroup(group)));
        return groupDtoList;
    }

}

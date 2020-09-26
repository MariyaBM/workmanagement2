package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Work;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkDto {

    private Long id;

    private String name;

    private String dimension;

    private double price;

    private String note;

    public Work toWork() {
        Work work = new Work();
        work.setId(id);
        work.setName(name);
        work.setDimension(dimension);
        work.setPrice(price);
        work.setNote(note);
        return work;
    }

    public static WorkDto fromWork(Work work) {
        WorkDto workDto = new WorkDto();
        workDto.setId(work.getId());
        workDto.setName(work.getName());
        workDto.setDimension(work.getDimension());
        workDto.setPrice(work.getPrice());
        workDto.setNote(work.getNote());
        return workDto;
    }

    public static List<WorkDto> workDtoList(List<Work> works) {
        List<WorkDto> workDtoList = new ArrayList<>();
        works.forEach(work -> workDtoList.add(fromWork(work)));
        return workDtoList;
    }

}

package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WsEventDto {



    @JsonRawValue
    private String body;


    public WsEventDto(ObjectType objectType, EventType eventType, String value) {
    }
}

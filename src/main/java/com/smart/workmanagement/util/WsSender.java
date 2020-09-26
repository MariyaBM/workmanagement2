package com.smart.workmanagement.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.smart.workmanagement.dto.EventType;
import com.smart.workmanagement.dto.ObjectType;
import com.smart.workmanagement.dto.WsEventDto;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

@Component
public class WsSender {

    private final SimpMessagingTemplate messagingTemplate;
    private final ObjectMapper mapper;

    public WsSender(SimpMessagingTemplate messagingTemplate, ObjectMapper mapper) {
        this.messagingTemplate = messagingTemplate;
        this.mapper = mapper;
    }

    public <T> BiConsumer<EventType, T> getSender(ObjectType objectType, Class view) {
        ObjectWriter writer = mapper
                .setConfig(mapper.getSerializationConfig())
                .writerWithView(view);

        return (EventType eventType, T payload) -> {
            String value = null;

            try {
                value = writer.writeValueAsString(payload);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            messagingTemplate.convertAndSend(
                    "/topic/activity",
                    new WsEventDto(objectType, eventType, value)
            );
        };
    }


}
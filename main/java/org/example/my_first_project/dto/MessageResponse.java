package org.example.my_first_project.dto;


import lombok.Builder;
import org.example.my_first_project.entity.Position;

import java.time.LocalDateTime;

import static org.example.my_first_project.entity.Position.ACTIVE;
import static org.example.my_first_project.entity.Position.fromString;

@Builder
public record MessageResponse(
        String message,
        LocalDateTime timestamp

) {
    public static MessageResponse success(String message) {
        return MessageResponse.builder()
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();

    }

    public static MessageResponse error(String message) {
        return MessageResponse.builder()
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}

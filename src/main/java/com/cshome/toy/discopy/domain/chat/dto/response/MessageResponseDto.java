package com.cshome.toy.discopy.domain.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponseDto {
    private Long id;
    private Long senderId;
    private String senderName;
    private String senderProfileUrl;
    private String content;
    private LocalDateTime timeStamp;
}

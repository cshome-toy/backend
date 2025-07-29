package com.cshome.toy.discopy.domain.chat.dto.mapper;

import com.cshome.toy.discopy.domain.chat.dto.response.MessageResponseDto;
import com.cshome.toy.discopy.domain.chat.entity.Message;
import com.cshome.toy.discopy.domain.member.entity.Member;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageDtoMapper {

    public MessageResponseDto toDto(Message message, Member sender) {
        return MessageResponseDto.builder()
            .id(message.getId())
            .senderId(sender.getId())
            .senderName(sender.getNickname())
            .senderProfileUrl("www.example.com")
            .content(message.getContent())
            .timeStamp(LocalDateTime.now())
            .build();
    }
}

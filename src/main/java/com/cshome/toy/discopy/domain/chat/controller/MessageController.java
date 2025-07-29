package com.cshome.toy.discopy.domain.chat.controller;

import com.cshome.toy.discopy.domain.chat.dto.request.MessageCreateRequestDto;
import com.cshome.toy.discopy.domain.chat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @MessageMapping("/servers/{serverId}/channels/{channelId}")
    public void sendMessage(@DestinationVariable String channelId, MessageCreateRequestDto message, SimpMessageHeaderAccessor accessor) {
        messageService.processMessage(channelId, message,accessor);
    }
}

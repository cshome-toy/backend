package com.cshome.toy.discopy.domain.chat.controller;

import com.cshome.toy.discopy.domain.chat.dto.response.MessageResponseDto;
import com.cshome.toy.discopy.domain.chat.service.ChatMessageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/servers/{serverId}/channels/{channelId}/message")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @Operation(summary = "디스코드 메시지 조회", description = "특정 채널의 메시지를 조회합니다.<br>" +
        "beforeId는 불러와야 하는 메시지의 직전 메시지 id, size는 불러올 메시지의 개수를 정합니다.")
    @PreAuthorize("hasRole(('USER'))")
    @GetMapping("")
    public List<MessageResponseDto> getMessages(
        @PathVariable Long serverId,
        @PathVariable Long channelId,
        @RequestParam(required = false) Long beforeId,
        @RequestParam(defaultValue = "50") int size) {

        return chatMessageService.findMessages(channelId, beforeId, size);
    }
}
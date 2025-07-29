package com.cshome.toy.discopy.domain.chat.controller;

import com.cshome.toy.discopy.domain.chat.dto.request.CreateChannelRequestDto;
import com.cshome.toy.discopy.domain.chat.dto.response.RetrieveChannelListDto;
import com.cshome.toy.discopy.domain.chat.entity.Channel;
import com.cshome.toy.discopy.domain.chat.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channels")
@RequiredArgsConstructor
@Tag(name = "Chat - Channel", description = "디스코드 채널")
public class ChannelController {

    private final ChannelService channelService;

    @Operation(summary = "디스코드 채널 생성", description = "디스코드의 새 채팅방을 생성할 수 있습니다.")
    @PreAuthorize("hasRole(('USER'))")
    @PostMapping("")
    public ResponseEntity<Long> createChannel(@RequestBody CreateChannelRequestDto dto) {
        Channel channel = channelService.createChannel(dto);
        return ResponseEntity.ok(channel.getId());
    }

    @Operation(summary = "디스코드 채널 조회", description = "특정 서버의 디스코드 채팅방 목록을 조회할 수 있습니다.")
    @PreAuthorize("hasRole(('USER'))")
    @GetMapping("")
    public ResponseEntity<List<RetrieveChannelListDto>> retrieveChannel(@RequestParam Long serverId) {
        List<RetrieveChannelListDto> chennels= channelService.retrieveChannel(serverId);
        return ResponseEntity.ok(chennels);
    }
}

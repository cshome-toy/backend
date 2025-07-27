package com.cshome.toy.discopy.domain.chat.controller;

import com.cshome.toy.discopy.domain.chat.dto.request.JoinServerRequestDto;
import com.cshome.toy.discopy.domain.chat.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/servers/{serverId}/participants")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @PutMapping("")
    public ResponseEntity<Void> joinServer(
        @PathVariable Long serverId,
        @RequestBody JoinServerRequestDto requestDto
    ) {
        participantService.join(serverId, requestDto);
        return ResponseEntity.ok().build();
    }
}
package com.cshome.toy.discopy.domain.chat.controller;

import com.cshome.toy.discopy.domain.chat.dto.request.JoinServerRequestDto;
import com.cshome.toy.discopy.domain.chat.service.ParticipantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/servers/{serverId}/participants")
@RequiredArgsConstructor
@Tag(name = "Chat - Participant", description = "디스코드 참가자")
public class ParticipantController {

    private final ParticipantService participantService;

    @Operation(summary = "디스코드 참가자 가입", description = "디스코드에 참가할 수 있습니다.")
    @PreAuthorize("hasRole(('USER'))")
    @PutMapping("")
    public ResponseEntity<Void> joinServer(
        @PathVariable Long serverId
    ) {
        participantService.join(serverId);
        return ResponseEntity.ok().build();
    }
}
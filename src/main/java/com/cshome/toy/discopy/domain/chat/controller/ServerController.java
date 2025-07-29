package com.cshome.toy.discopy.domain.chat.controller;

import com.cshome.toy.discopy.domain.chat.dto.request.CreateServerRequestDto;
import com.cshome.toy.discopy.domain.chat.dto.response.RetrieveChannelListDto;
import com.cshome.toy.discopy.domain.chat.dto.response.RetrieveServerListDto;
import com.cshome.toy.discopy.domain.chat.entity.Server;
import com.cshome.toy.discopy.domain.chat.service.ServerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/servers")
@RequiredArgsConstructor
@Tag(name = "Chat - Server", description = "디스코드 서버")
public class ServerController {

    private final ServerService serverService;

    @Operation(summary = "디스코드 서버 생성", description = "새 디스코드 서버를 생성할 수 있습니다.")
    @PreAuthorize("hasRole(('USER'))")
    @PostMapping("")
    public ResponseEntity<Long> createServer(@RequestBody CreateServerRequestDto request) {
        Server server = serverService.createServer(request);
        return ResponseEntity.ok(server.getId());
    }

    @Operation(summary = "디스코드 서버 조회", description = "모든 디스코드 서버를 조회할 수 있습니다.")
    @PreAuthorize("hasRole(('USER'))")
    @GetMapping("")
    public ResponseEntity<List<RetrieveServerListDto>> retrieveServerList() {
        List<RetrieveServerListDto> serverList = serverService.retrieveAllServer();
        return ResponseEntity.ok(serverList);
    }

    @Operation(summary = "내 디스코드 서버 조회", description = "내가 들어가 있는 모든 디스코드 서버를 조회할 수 있습니다.")
    @PreAuthorize("hasRole(('USER'))")
    @GetMapping("/my")
    public ResponseEntity<List<RetrieveServerListDto>> retrieveMyServerList() {
        List<RetrieveServerListDto> serverList = serverService.retrieveMyServers();
        return ResponseEntity.ok(serverList);
    }
}

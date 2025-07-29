package com.cshome.toy.discopy.domain.chat.service;

import com.cshome.toy.discopy.domain.chat.dto.mapper.ServerDtoMapper;
import com.cshome.toy.discopy.domain.chat.dto.request.CreateServerRequestDto;
import com.cshome.toy.discopy.domain.chat.dto.response.RetrieveServerListDto;
import com.cshome.toy.discopy.domain.chat.entity.Server;
import com.cshome.toy.discopy.domain.chat.repository.ParticipantRepository;
import com.cshome.toy.discopy.domain.chat.repository.ServerRepository;
import com.cshome.toy.discopy.global.provider.LoginMemberProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ServerService {

    private final ServerRepository serverRepository;
    private final LoginMemberProvider loginMemberProvider;
    private final ParticipantRepository participantRepository;
    private final ServerDtoMapper mapper;

    public Server createServer(CreateServerRequestDto requestDto) {
        return serverRepository.save(Server.builder()
            .name(requestDto.getName())
            .build());
    }

    public List<RetrieveServerListDto> retrieveAllServer() {
        List<Server> servers = serverRepository.findAll();
        return servers.stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    public List<RetrieveServerListDto> retrieveMyServers() {
        Long memberId = loginMemberProvider.getCurrentUserId();
        List<Long> serverIds = participantRepository.findServerIdsByMemberId((memberId));
        List<Server> servers = serverRepository.findAllById(serverIds);

        return servers.stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }
}
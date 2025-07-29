package com.cshome.toy.discopy.domain.chat.service;

import com.cshome.toy.discopy.domain.chat.dto.request.CreateServerRequestDto;
import com.cshome.toy.discopy.domain.chat.dto.response.RetrieveServerListDto;
import com.cshome.toy.discopy.domain.chat.entity.Server;
import com.cshome.toy.discopy.domain.chat.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;

    public Server createServer(CreateServerRequestDto requestDto) {
        return serverRepository.save(Server.builder()
            .name(requestDto.getName())
            .build());
    }

    public List<RetrieveServerListDto> retrieveAllServer() {
        List<Server> servers = serverRepository.findAll();
        return servers.stream()
            .map(server -> new RetrieveServerListDto(server.getId(), server.getName()))
            .collect(Collectors.toList());
    }
}
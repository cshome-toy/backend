package com.cshome.toy.discopy.domain.chat.service;

import com.cshome.toy.discopy.domain.chat.dto.request.CreateServerRequestDto;
import com.cshome.toy.discopy.domain.chat.entity.Server;
import com.cshome.toy.discopy.domain.chat.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;

    public Server createServer(CreateServerRequestDto requestDto) {
        return serverRepository.save(Server.builder()
            .name(requestDto.getName())
            .build());
    }
}
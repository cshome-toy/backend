package com.cshome.toy.discopy.domain.chat.dto.mapper;

import com.cshome.toy.discopy.domain.chat.dto.response.RetrieveServerListDto;
import com.cshome.toy.discopy.domain.chat.entity.Server;
import org.springframework.stereotype.Component;

@Component
public class ServerDtoMapper {
    public RetrieveServerListDto toDto(Server server) {
        return RetrieveServerListDto.builder()
            .serverId(server.getId())
            .serverName(server.getName())
            .serverImageUrl("www.example.com")
            .build();
    }
}

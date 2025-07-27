package com.cshome.toy.discopy.domain.chat.service;

import com.cshome.toy.discopy.domain.chat.dto.request.CreateChannelRequestDto;
import com.cshome.toy.discopy.domain.chat.dto.response.RetrieveChannelListDto;
import com.cshome.toy.discopy.domain.chat.entity.Channel;
import com.cshome.toy.discopy.domain.chat.entity.Server;
import com.cshome.toy.discopy.domain.chat.repository.ChannelRepository;
import com.cshome.toy.discopy.domain.chat.repository.ServerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChannelService {

    private final ServerRepository serverRepository;
    private final ChannelRepository channelRepository;

    public Channel createChannel(CreateChannelRequestDto dto) {
        Server server = serverRepository.findById(dto.getServerId())
            .orElseThrow(() -> new IllegalArgumentException("해당 서버가 존재하지 않습니다."));

        Channel channel = Channel.builder()
            .name(dto.getName())
            .serverId(server.getId())
            .build();

        return channelRepository.save(channel);
    }

    public List<RetrieveChannelListDto> retrieveChannel(Long serverId) {

        List<Channel> channels = channelRepository.findAllByServerId(serverId);

        return channels.stream()
            .map(channel -> new RetrieveChannelListDto(channel.getId(), channel.getName()))
            .collect(Collectors.toList());
    }
}

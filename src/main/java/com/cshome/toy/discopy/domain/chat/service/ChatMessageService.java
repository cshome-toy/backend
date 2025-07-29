package com.cshome.toy.discopy.domain.chat.service;

import com.cshome.toy.discopy.domain.chat.dto.mapper.MessageDtoMapper;
import com.cshome.toy.discopy.domain.chat.dto.response.MessageResponseDto;
import com.cshome.toy.discopy.domain.chat.entity.Message;
import com.cshome.toy.discopy.domain.chat.repository.MessageRepository;
import com.cshome.toy.discopy.domain.member.entity.Member;
import com.cshome.toy.discopy.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatMessageService {
    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;
    private final MessageDtoMapper mapper;

    public List<MessageResponseDto> findMessages(Long channelId, Long beforeId, int size) {
        Pageable pageable = PageRequest.of(0, size);

        List<Message> messages = messageRepository.findByChannelIdWithPagination(channelId, beforeId, pageable);

        Collections.reverse(messages);

        return messages.stream()
            .map(this::toMessageResponseDto)
            .toList();
    }

    private MessageResponseDto toMessageResponseDto(Message message) {
        Member sender = memberRepository.findById(message.getSenderId()).orElse(null);
        return mapper.toDto(message,sender);
    }
}

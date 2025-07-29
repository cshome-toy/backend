package com.cshome.toy.discopy.domain.chat.service;


import com.cshome.toy.discopy.domain.chat.dto.request.MessageCreateRequestDto;
import com.cshome.toy.discopy.domain.chat.dto.response.MessageResponseDto;
import com.cshome.toy.discopy.domain.chat.entity.Channel;
import com.cshome.toy.discopy.domain.chat.entity.Message;
import com.cshome.toy.discopy.domain.chat.repository.ChannelRepository;
import com.cshome.toy.discopy.domain.chat.repository.MessageRepository;
import com.cshome.toy.discopy.domain.member.entity.Member;
import com.cshome.toy.discopy.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChannelRepository channelRepository;
    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;

    public void processMessage(String channelId, MessageCreateRequestDto messageRequestDto, SimpMessageHeaderAccessor accessor) {
        Channel channel = channelRepository.findById(Long.valueOf(channelId))
            .orElseThrow(() -> new IllegalArgumentException("채널을 찾을 수 없습니다"));

        Long senderId = (Long) Objects.requireNonNull(accessor.getSessionAttributes()).get("userId");
        Member sender = memberRepository.findById(senderId)
            .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다"));

        Message savedMessage = messageRepository.save(
            Message.builder()
                .channelId(channel.getId())
                .content(messageRequestDto.getContent())
                .senderId(sender.getId())
                .build()
        );

        System.out.println(savedMessage.getSendTime());

        MessageResponseDto message = MessageResponseDto.builder()
            .id(savedMessage.getId())
            .senderId(sender.getId())
            .senderName(sender.getNickname())
            .senderProfileUrl("www.example.com")
            .content(savedMessage.getContent())
            .timeStamp(savedMessage.getSendTime())
            .build();

        messagingTemplate.convertAndSend("/sub/channel/" + channelId, message);
    }
}

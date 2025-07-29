package com.cshome.toy.discopy.domain.chat.service;

import com.cshome.toy.discopy.domain.chat.dto.request.JoinServerRequestDto;
import com.cshome.toy.discopy.domain.chat.entity.Participant;
import com.cshome.toy.discopy.domain.chat.repository.ParticipantRepository;
import com.cshome.toy.discopy.domain.chat.repository.ServerRepository;
import com.cshome.toy.discopy.domain.member.repository.MemberRepository;
import com.cshome.toy.discopy.domain.member.service.MemberService;
import com.cshome.toy.discopy.global.provider.LoginMemberProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ParticipantService {

    private final ServerRepository serverRepository;
    private final MemberRepository memberRepository;
    private final ParticipantRepository participantRepository;
    private final LoginMemberProvider loginMemberProvider;

    public void join(Long serverId) {
        Long memberId = loginMemberProvider.getCurrentUserId();
        if (participantRepository.existsByMemberIdAndServerId(memberId, serverId)) {
            throw new IllegalStateException("이미 참가한 서버입니다.");
        }

        if(!serverRepository.existsById(serverId)) {
            throw new NoSuchElementException("해당 서버를 찾을 수 없습니다.");
        }

        if(!memberRepository.existsById(memberId)) {
            throw new NoSuchElementException("해당 회원을 찾을 수 없습니다.");
        }

        Participant participant = Participant.builder()
            .serverId(serverId)
            .memberId(memberId)
            .joinDate(LocalDateTime.now())
            .build();

        participantRepository.save(participant);
    }
}
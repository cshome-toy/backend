package com.cshome.toy.discopy.global.provider;

import com.cshome.toy.discopy.domain.member.dto.MemberInfoDto;
import com.cshome.toy.discopy.domain.member.entity.Member;
import com.cshome.toy.discopy.domain.member.repository.MemberRepository;
import com.cshome.toy.discopy.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginMemberProvider {
    private final MemberRepository memberRepository;

    public Long getCurrentUserId() {
        return SecurityUtil.getCurrentUserId();
    }

    public Member getCurrentMember() {
        Long memberId = SecurityUtil.getCurrentUserId();
        return memberRepository.findById(memberId)
            .orElseThrow(()->new IllegalArgumentException("해당 회원 찾을 수 없습니다."));
    }

    public MemberInfoDto getCurrentMemberInfoDto() {
        return MemberInfoDto.toMemberInfoDto(getCurrentMember());
    }
}

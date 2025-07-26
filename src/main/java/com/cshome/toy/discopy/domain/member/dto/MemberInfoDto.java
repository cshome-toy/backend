package com.cshome.toy.discopy.domain.member.dto;

import com.cshome.toy.discopy.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInfoDto {
    private String email;
    private LocalDate birthday;
    private String nickname;
    private String username;

    public static MemberInfoDto toMemberInfoDto(Member member) {
        return MemberInfoDto.builder()
                .email(member.getEmail())
                .birthday(member.getBirthday())
                .nickname(member.getNickname())
                .username(member.getUsername())
                .build();
    }
}

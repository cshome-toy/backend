package com.cshome.toy.discopy.domain.member.dto;

import com.cshome.toy.discopy.domain.member.entity.Member;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    private String email;
    private String password;
    private LocalDate birthday;
    private String nickname;
    private String username;

    static public MemberDto toDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .birthday(member.getBirthday())
                .username(member.getUsername())
                .build();
    }
    public Member toEntity() {
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .nickname(nickname)
                .birthday(birthday)
                .username(username)
                .build();
    }
}

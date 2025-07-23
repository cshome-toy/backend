package com.cshome.toy.discopy.domain.member.dto;

import com.cshome.toy.discopy.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    private String email;
    private String password;
    private String name;
    public Member toEntity(String encodePassword) {
        return Member.builder()
                .email(email)
                .name(name)
                .password(encodePassword)
                .build();
    }
}

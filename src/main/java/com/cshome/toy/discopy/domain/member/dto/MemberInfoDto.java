package com.cshome.toy.discopy.domain.member.dto;

import com.cshome.toy.discopy.domain.member.Member;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "사용자 이메일 작성",example = "test@email.com")
    private String email;

    @Schema(description = "사용자 생년원일",example = "2002-01-01")
    private LocalDate birthday;

    @Schema(description = "사용자 별명",example = "꼬북이",nullable = true)
    private String nickname;

    @Schema(description = "사용자 이름",example = "홍길동")
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

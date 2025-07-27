package com.cshome.toy.discopy.domain.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignInDto {
    @Schema(description = "사용자 이메일 작성",nullable = false,example = "test@email.com")
    private String email;
    @Schema(description = "사용자 비밀번호",nullable = false,example = "1234")
    private String password;
}
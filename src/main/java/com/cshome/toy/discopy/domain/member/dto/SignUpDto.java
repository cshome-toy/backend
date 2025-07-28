package com.cshome.toy.discopy.domain.member.dto;

import com.cshome.toy.discopy.domain.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {
    @NotBlank(message = "이메일은 필수입니다.")
    @Schema(description = "사용자 이메일 작성",nullable = false,example = "test@email.com")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Schema(description = "사용자 비밀번호",nullable = false,example = "1234")
    private String password;

    @NotBlank(message = "사용자명은 필수입니다.")
    @Schema(description = "사용자 이름",nullable = false,example = "홍길동")
    private String username;

    @Schema(description = "사용자 별명",example = "꼬북이",nullable = true)
    private String nickname;

    @NotNull(message = "생년월일은 필수입니다.")
    @Schema(description = "사용자 생년원일",example = "2002-01-01")
    private LocalDate birthday;



    public Member toEntity(String encodePassword) {
        return Member.builder()
                .email(email)
                .nickname(nickname)
                .username(username)
                .birthday(birthday)
                .password(encodePassword)
                .build();
    }
}

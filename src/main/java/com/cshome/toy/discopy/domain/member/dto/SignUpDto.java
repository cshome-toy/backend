package com.cshome.toy.discopy.domain.member.dto;

import com.cshome.toy.discopy.domain.member.Member;
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
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    private String nickname;

    @NotNull(message = "생년월일은 필수입니다.")
    private LocalDate birthday;

    @NotBlank(message = "사용자명은 필수입니다.")
    private String username;
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

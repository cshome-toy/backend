package com.cshome.toy.discopy.domain.member.controller;

import com.cshome.toy.discopy.domain.member.dto.*;
import com.cshome.toy.discopy.domain.member.entity.Member;
import com.cshome.toy.discopy.domain.member.service.MemberService;
import com.cshome.toy.discopy.global.provider.LoginMemberProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
@Tag(name = "멤버 API", description = "회원 로그인/가입/조회 API")
public class MemberController {
    private final MemberService memberService;
    private final LoginMemberProvider loginMemberProvider;

    @Operation(
            summary = "로그인 API",
            description = "이메일과 비밀번호를 사용해 JWT AccessToken과 RefreshToken을 발급받습니다."
    )
    @PostMapping("/sign-in")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {

        JwtToken jwtToken = memberService.signIn(signInDto);
        return jwtToken;
    }
    @Operation(
            summary = "회원가입 API",
            description = "email, password, username, nickname, birthday을 받아 회원을 등록합니다."
    )
    @PostMapping("sign-up")
    public ResponseEntity<MemberDto> signUp(@RequestBody SignUpDto signUpDto) {
        MemberDto memberDto = memberService.signUp(signUpDto);
        return ResponseEntity.ok(memberDto);
    }
    @Operation(
            summary = "현재 로그인한 사용자 정보 조회 API",
            description = "현재 인증된 사용자의 email,username,birthday,nickname 정보를 반환합니다." +
                    "401에러시 JWT 토큰 누락 또는 만료로 인한 오류일 가능성 있음"
    )
    @GetMapping("/current-user")
    public ResponseEntity<MemberInfoDto> currentUser() {
        MemberInfoDto memberDto = loginMemberProvider.getCurrentMemberInfoDto();
        return ResponseEntity.ok(memberDto);
    }


}

package com.cshome.toy.discopy.domain.member.controller;

import com.cshome.toy.discopy.domain.member.dto.JwtToken;
import com.cshome.toy.discopy.domain.member.dto.MemberDto;
import com.cshome.toy.discopy.domain.member.dto.SignUpDto;
import com.cshome.toy.discopy.security.SecurityUtil;
import com.cshome.toy.discopy.domain.member.dto.SignInDto;
import com.cshome.toy.discopy.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-in")
    public JwtToken signIn(@RequestBody SignInDto signInDto) {

        JwtToken jwtToken = memberService.signIn(signInDto);
        return jwtToken;
    }
    @PostMapping("sign-up")
    public ResponseEntity<MemberDto> signUp(@RequestBody SignUpDto signUpDto) {
        MemberDto memberDto = memberService.signUp(signUpDto);
        return ResponseEntity.ok(memberDto);
    }
    @PostMapping("/current-user")
    public String currentUser() {
        return SecurityUtil.getCurrentUserEmail();
    }

}

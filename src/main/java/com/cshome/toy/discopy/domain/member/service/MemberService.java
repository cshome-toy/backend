package com.cshome.toy.discopy.domain.member.service;

import com.cshome.toy.discopy.domain.member.entity.Member;
import com.cshome.toy.discopy.domain.member.dto.*;

import com.cshome.toy.discopy.domain.member.repository.MemberRepository;
import com.cshome.toy.discopy.global.provider.JwtTokenProvider;
import com.cshome.toy.discopy.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public JwtToken signIn(SignInDto signInDto) {
        log.info("signIn email: {} password: {}", signInDto.getEmail(), signInDto.getPassword());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(signInDto.getEmail(), signInDto.getPassword());
        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        MemberDetails memberDetails = (MemberDetails) authentication.getPrincipal();
        Long memberId = memberDetails.getId();

        JwtToken jwtToken = jwtTokenProvider.generateToken(memberId,authentication.getAuthorities());

        log.info("jwtToken accessToken: {}, refreshToken: {}",
                jwtToken.getAccessToken(), jwtToken.getRefreshToken());


        return jwtToken;

    }
    @Transactional
    public MemberDto signUp(SignUpDto signUpDto) {

        if(memberRepository.existsByEmail(signUpDto.getEmail())){
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        //password 암호화
        String encodedPassword = passwordEncoder.encode(signUpDto.getPassword());
        return MemberDto.toDto(memberRepository.save(signUpDto.toEntity(encodedPassword)));
    }
}

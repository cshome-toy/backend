package com.cshome.toy.discopy.domain.member.service;

import com.cshome.toy.discopy.domain.member.dto.JwtToken;

import com.cshome.toy.discopy.domain.member.dto.MemberDto;
import com.cshome.toy.discopy.domain.member.dto.SignUpDto;
import com.cshome.toy.discopy.domain.member.repository.MemberRepository;
import com.cshome.toy.discopy.security.JwtTokenProvider;
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
    public JwtToken signIn(String username,String password){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

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

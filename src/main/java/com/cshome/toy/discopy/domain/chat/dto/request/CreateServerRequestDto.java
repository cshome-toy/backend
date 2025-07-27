package com.cshome.toy.discopy.domain.chat.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateServerRequestDto {
    @Schema(description = "서버 이름", example = "CShome 채팅 서버", required = true)
    private String name;
}
package com.cshome.toy.discopy.domain.chat.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChannelRequestDto {

    @Schema(description = "서버 ID", example = "1", required = true)
    private Long serverId;

    @Schema(description = "채널 이름", example = "일반 채팅", required = true)
    private String name;
}

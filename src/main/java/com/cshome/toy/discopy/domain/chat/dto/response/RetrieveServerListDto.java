package com.cshome.toy.discopy.domain.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveServerListDto {
    Long serverId;
    String serverName;
    String serverImageUrl;
}

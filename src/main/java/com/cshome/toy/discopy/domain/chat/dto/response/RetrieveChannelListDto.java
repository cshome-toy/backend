package com.cshome.toy.discopy.domain.chat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RetrieveChannelListDto {
    Long channelId;
    String channelName;
}

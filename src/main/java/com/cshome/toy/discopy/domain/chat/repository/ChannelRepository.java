package com.cshome.toy.discopy.domain.chat.repository;

import com.cshome.toy.discopy.domain.chat.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {

    List<Channel> findAllByServerId(Long serverId);
}

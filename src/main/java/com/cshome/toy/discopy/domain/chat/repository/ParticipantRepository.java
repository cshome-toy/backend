package com.cshome.toy.discopy.domain.chat.repository;

import com.cshome.toy.discopy.domain.chat.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    boolean existsByMemberIdAndServerId(Long memberId, Long serverId);
}

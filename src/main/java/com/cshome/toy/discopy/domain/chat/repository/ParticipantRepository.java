package com.cshome.toy.discopy.domain.chat.repository;

import com.cshome.toy.discopy.domain.chat.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    boolean existsByMemberIdAndServerId(Long memberId, Long serverId);

    @Query("SELECT p.serverId FROM Participant p WHERE p.memberId = :memberId")
    List<Long> findServerIdsByMemberId(Long memberId);
}

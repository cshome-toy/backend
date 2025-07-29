package com.cshome.toy.discopy.domain.chat.repository;

import com.cshome.toy.discopy.domain.chat.entity.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query("SELECT m FROM Message m WHERE m.channelId = :channelId " +
        "AND (:beforeId IS NULL OR m.id < :beforeId) " +
        "ORDER BY m.id DESC")
    List<Message> findByChannelIdWithPagination(
        @Param("channelId") Long channelId,
        @Param("beforeId") Long beforeId,
        Pageable pageable
    );
}

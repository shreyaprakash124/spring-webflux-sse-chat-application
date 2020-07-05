package com.flolabs.webfluxsse.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.flolabs.webfluxsse.entity.MessageEntity;

import reactor.core.publisher.Flux;

@Repository
public interface ChatRepository extends R2dbcRepository<MessageEntity, Long> {

	Flux<MessageEntity> findByChannelId(String channelId);
}

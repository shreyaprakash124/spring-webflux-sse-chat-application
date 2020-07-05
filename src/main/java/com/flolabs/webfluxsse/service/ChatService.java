package com.flolabs.webfluxsse.service;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.flolabs.webfluxsse.entity.MessageEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ChatService {
	
	/**
	 * Fetch all the notifications
	 * 
	 * @param userId
	 * @return
	 */
	public Flux<ServerSentEvent<MessageEntity>> getAllMessagesById(String channelId);
	
	/**
	 * Create notification
	 * 
	 * @param userNotificationEntity
	 */
	public Mono<MessageEntity> sendNewMessages(MessageEntity notificationDTO);
}

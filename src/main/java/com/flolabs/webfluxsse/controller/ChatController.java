package com.flolabs.webfluxsse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.RestController;

import com.flolabs.webfluxsse.api.ChatApi;
import com.flolabs.webfluxsse.entity.MessageEntity;
import com.flolabs.webfluxsse.exception.ChatException;
import com.flolabs.webfluxsse.service.ChatService;

import io.swagger.annotations.Api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api(tags = "Message")
@RestController
public class ChatController implements ChatApi {

	@Autowired
	ChatService userService;

	@Override
	public Flux<ServerSentEvent<MessageEntity>> getAllMessagesById(String channelId) {
		return userService.getAllMessagesById(channelId);
	}

	@Override
	public Mono<MessageEntity> sendNewMessages(MessageEntity userNotificationEntity) {
		if(userNotificationEntity !=null) {
			return userService.sendNewMessages(userNotificationEntity);
		}else {
			throw new ChatException("Bad request Exception");
		}	
	}

}

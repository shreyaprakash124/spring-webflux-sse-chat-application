package com.flolabs.webfluxsse.api;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flolabs.webfluxsse.entity.MessageEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(value = "messages")
public interface ChatApi {

	@ApiOperation(value = "Returns all relevant messages for a channel", nickname = "getAllMessagesById", response = Flux.class, tags = {
			"Message" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "List of all messages for a channel Id successfully fetched", response = Flux.class) })
	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<ServerSentEvent<MessageEntity>> getAllMessagesById(@RequestParam(value = "channelId") String channelId);

	@ApiOperation(value = "Send a new message to a channel Id", nickname = "sendNewMessages", tags = {
			"Message" })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully send the message") })
	@PostMapping(consumes = { "application/json" })
	Mono<MessageEntity> sendNewMessages(@RequestBody MessageEntity message);

}

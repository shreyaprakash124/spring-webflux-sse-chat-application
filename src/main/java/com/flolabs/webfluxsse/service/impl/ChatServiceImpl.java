package com.flolabs.webfluxsse.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.flolabs.webfluxsse.entity.MessageEntity;
import com.flolabs.webfluxsse.repository.ChatRepository;
import com.flolabs.webfluxsse.service.ChatService;

import reactor.core.Disposable;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatRepository chatRepository;

	Map<String, Pair<FluxSink<MessageEntity>, FluxProcessor<MessageEntity, MessageEntity>>> lookUpValues = new HashMap<>();

	@Override
	public Flux<ServerSentEvent<MessageEntity>> getAllMessagesById(String channelId) {
		FluxProcessor<MessageEntity, MessageEntity> emitter;
		FluxSink<MessageEntity> sink;
		if (lookUpValues.containsKey(channelId)) {
			emitter = lookUpValues.get(channelId).getSecond();
			sink = lookUpValues.get(channelId).getFirst();
		} else {
			emitter = EmitterProcessor.create();
			sink = emitter.sink();
			sink.onCancel(new Disposable() {
				@Override
				public void dispose() {
					lookUpValues.remove(channelId);

				}
			});
			lookUpValues.put(channelId, Pair.of(sink, emitter));
		}

		Flux<ServerSentEvent<MessageEntity>> sinkMessage = emitter.filter(u -> u.getChannelId().equals(channelId))
				.map(e -> ServerSentEvent.builder(e).build());
		Flux<MessageEntity> previousMessage = chatRepository.findByChannelId(channelId);
		return (previousMessage.map(e -> ServerSentEvent.builder(e).build())).concatWith(sinkMessage);

	}

	@Override
	public Mono<MessageEntity> sendNewMessages(MessageEntity notificationDTO) {
		if (lookUpValues.containsKey(notificationDTO.getChannelId())) {
			lookUpValues.get(notificationDTO.getChannelId()).getFirst().next(notificationDTO);
		}
		return chatRepository.save(notificationDTO);
	}

}

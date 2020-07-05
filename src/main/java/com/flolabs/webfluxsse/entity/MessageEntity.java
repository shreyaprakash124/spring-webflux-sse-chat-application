package com.flolabs.webfluxsse.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("messages")
public class MessageEntity {

	@Id
	@Column(value = "message_id")
	private Long messageId;
	@Column(value = "sender")
	private String sender;
	@Column(value = "message")
	private String message;
	@Column(value = "receiver")
	private String receiver;
	@Column(value = "channel_id")
	private String channelId;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

}

package com.ctzn.springmongoreactivechat.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.reactive.socket.WebSocketSession;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Document
@TypeAlias("messages")
public class Message {
    @Id
    private String id;
    @NonNull
    private String sessionId;
    @NonNull
    private String clientId;
    @NonNull
    private String type;
    @NonNull
    private String author;
    @NonNull
    private String text;
    private Date timestamp = new Date();

    public static Message newInfo(String message) {
        return new Message("", "", "info", "", message);
    }

    public static Message newInstance(WebSocketSession session, IncomingMessage message) {
        return new Message(session.getId(), message.getClientId(), "msg", session.getId(), message.getMessageText());
    }
}
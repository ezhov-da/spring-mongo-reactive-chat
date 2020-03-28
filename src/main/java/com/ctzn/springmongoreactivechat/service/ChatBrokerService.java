package com.ctzn.springmongoreactivechat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatBrokerService {

    private Logger LOG = LoggerFactory.getLogger(ChatBrokerService.class);

    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public boolean addClient(WebSocketSession session) {
        LOG.info(" + [{}] (total clients: {})", session.getId(), sessions.size() + 1);
        return sessions.put(session.getId(), session) == null;
    }

    public void removeClient(WebSocketSession session) {
        LOG.info(" x [{}] (total clients: {})", session.getId(), sessions.size() - 1);
        sessions.remove(session.getId());
    }
}
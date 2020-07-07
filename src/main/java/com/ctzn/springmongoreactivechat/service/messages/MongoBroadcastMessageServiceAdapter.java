package com.ctzn.springmongoreactivechat.service.messages;

import com.ctzn.springmongoreactivechat.domain.Message;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Profile("mongo-service")
public class MongoBroadcastMessageServiceAdapter implements BroadcastMessageService {
    private final ReactiveMongoOperations mongo;
    private final Flux<Message> cache;

    public MongoBroadcastMessageServiceAdapter(ReactiveMongoOperations mongo) {
        this.mongo = mongo;
        cache = mongo.tail(new BasicQuery("{}"), Message.class).cache(50);
    }

    @Override
    public Flux<Message> getTopic() {
        return cache;
    }

    @Override
    public Mono<Message> saveMessage(Message message) {
        return mongo.save(message);
    }
}
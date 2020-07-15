package com.ctzn.springmongoreactivechat.repository;

import com.ctzn.springmongoreactivechat.domain.CompoundWebVideo;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mongo-video-transcoder")
public interface CompoundWebVideoRepository extends ReactiveMongoRepository<CompoundWebVideo, String> {
}

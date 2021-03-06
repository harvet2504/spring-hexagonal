package com.example.springhexagonal.adapters.persistance;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import com.example.springhexagonal.adapters.persistance.entity.ZipCodeEntity;

@Repository
public interface ZipCodeRepository extends ReactiveMongoRepository<ZipCodeEntity, String> {
  Mono<ZipCodeEntity> findByZipCode(String zipCode);
}

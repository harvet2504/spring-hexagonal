package com.example.springhexagonal.adapters.persistance;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.example.springhexagonal.adapters.persistance.entity.StoreEntity;

@Repository
public interface StoreRepository extends ReactiveMongoRepository<StoreEntity, String> {
}

package com.example.springhexagonal.application.ports.out;

import reactor.core.publisher.Mono;
import com.example.springhexagonal.application.domain.Store;

public interface StorePort {
  Mono<Store> addStore(Store store);
}

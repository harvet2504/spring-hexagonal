package com.example.springhexagonal.application.ports.in;


import reactor.core.publisher.Mono;
import com.example.springhexagonal.application.domain.Store;

public interface StoreManagementUseCase {
  Mono<Store> addStore(Store store);
}

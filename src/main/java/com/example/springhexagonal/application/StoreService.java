package com.example.springhexagonal.application;

import com.example.springhexagonal.application.domain.Store;
import com.example.springhexagonal.application.ports.in.StoreManagementUseCase;
import com.example.springhexagonal.application.ports.out.StorePort;
import com.example.springhexagonal.application.ports.out.UpdateStoreCountInZipCodePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import javax.naming.directory.InvalidAttributesException;

@Service
public class StoreService implements StoreManagementUseCase {
  private final StorePort storePort;
  private final UpdateStoreCountInZipCodePort updateStoreCountInZipCodePort;

  @Autowired
  public StoreService(StorePort storePort, UpdateStoreCountInZipCodePort updateStoreCountInZipCodePort) {
    this.storePort = storePort;
    this.updateStoreCountInZipCodePort = updateStoreCountInZipCodePort;
  }

  @Override
  @Transactional
  public Mono<Store> addStore(Store store) {
    if (store.isValid()) {
      return storePort.addStore(store).map(result -> {
        updateStoreCountInZipCodePort.incrementStoreCount(store.getLocation().getZipCode());
        return result;
      });
    }
    return Mono.error(InvalidAttributesException::new);
  }
}

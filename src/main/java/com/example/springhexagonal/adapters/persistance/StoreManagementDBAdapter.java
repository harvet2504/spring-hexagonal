package com.example.springhexagonal.adapters.persistance;

import com.example.springhexagonal.application.domain.Store;
import com.example.springhexagonal.application.ports.out.StorePort;
import com.example.springhexagonal.application.ports.out.UpdateStoreCountInZipCodePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import com.example.springhexagonal.adapters.persistance.entity.StoreEntity;
import com.example.springhexagonal.adapters.persistance.entity.ZipCodeEntity;

@Component
public class StoreManagementDBAdapter implements StorePort, UpdateStoreCountInZipCodePort {
  private final StoreRepository storeRepository;
  private final ZipCodeRepository zipCodeRepository;

  @Autowired
  public StoreManagementDBAdapter(StoreRepository storeRepository, ZipCodeRepository zipCodeRepository) {
    this.storeRepository = storeRepository;
    this.zipCodeRepository = zipCodeRepository;
  }

  @Override
  public Mono<Store> addStore(Store store) {
    return storeRepository.save(StoreEntity.fromDomain(store)).map(StoreEntity::toDomain);
  }

  @Override
  public void incrementStoreCount(String zipCode) {
    zipCodeRepository.findByZipCode(zipCode)
      .flatMap(zipCodeEntity -> zipCodeRepository.save(new ZipCodeEntity(zipCodeEntity.getId(), zipCodeEntity.getZipCode(), zipCodeEntity.getStoreCount() + 1)))
      .subscribe();
  }
}

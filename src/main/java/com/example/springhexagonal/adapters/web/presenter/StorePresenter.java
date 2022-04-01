package com.example.springhexagonal.adapters.web.presenter;

import com.example.springhexagonal.application.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.springhexagonal.application.domain.Store;

@Data
@AllArgsConstructor
public class StorePresenter {
  private String id;
  private final String name;
  private final String zipCode;
  private final Double latitude;
  private final Double longitude;


  public Store toDomain() {
    return new Store(name, new Location(zipCode, latitude, longitude));
  }

  public static StorePresenter fromDomain(Store store) {
    return new StorePresenter(
      store.getId(),
      store.getName(),
      store.getLocation().getZipCode(),
      store.getLocation().getLatitude(),
      store.getLocation().getLongitude());
  }
}

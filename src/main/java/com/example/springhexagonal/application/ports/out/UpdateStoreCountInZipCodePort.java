package com.example.springhexagonal.application.ports.out;

public interface UpdateStoreCountInZipCodePort {
  void incrementStoreCount(String zipCode);
}

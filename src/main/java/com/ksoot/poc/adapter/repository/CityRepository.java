package com.ksoot.poc.adapter.repository;

import com.ksoot.poc.domain.model.City;
import java.util.List;
import java.util.Optional;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

 @JaversSpringDataAuditable
public interface CityRepository extends MongoRepository<City, String> {

  boolean existsByCode(final String code);

  Optional<City> findByCode(final String code);

  List<City> findAllByStateId(final String stateId);
}

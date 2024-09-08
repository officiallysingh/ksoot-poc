package com.ksoot.poc.adapter.repository;

import com.ksoot.poc.domain.model.State;
import java.util.Optional;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

 @JaversSpringDataAuditable
public interface StateRepository extends MongoRepository<State, String> {

  boolean existsByCode(final String code);

  Optional<State> findByCode(final String code);
}

package com.ksoot.poc.domain.service;

import com.ksoot.poc.domain.model.City;
import com.ksoot.poc.domain.model.State;
import com.ksoot.poc.domain.model.dto.CityCreationRQ;
import com.ksoot.poc.domain.model.dto.CityUpdationRQ;
import com.ksoot.poc.domain.model.dto.StateCreationRQ;
import com.ksoot.poc.domain.model.dto.StateUpdationRQ;
import java.util.List;

public interface LocationService {

  Boolean doesStateExists(String code);

  State createState(StateCreationRQ request);

  State getStateById(String id);

  State getStateByCode(String code);

  List<State> getAllStates();

  State updateState(String id, StateUpdationRQ request);

  void deleteState(String id);

  // -------- Cities ----------
  Boolean doesCityExists(String code);

  City createCity(String stateId, CityCreationRQ request);

  City getCityById(String id);

  City getCityByCode(String code);

  List<City> findAllCitiesByStateId(String stateId);

  List<City> getAllCities();

  City updateCity(String id, CityUpdationRQ request);

  void deleteCity(String id);
}

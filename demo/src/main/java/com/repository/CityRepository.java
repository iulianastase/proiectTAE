package com.repository;

import com.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by inastase on 11/23/2016.
 */

public interface CityRepository extends JpaRepository<City, Long>{

     City findByCityName(String cityName);
}

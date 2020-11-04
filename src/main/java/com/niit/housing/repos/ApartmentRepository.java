package com.niit.housing.repos;

import com.niit.housing.entity.Apartment;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, Long> {

}

package com.niit.housing.repos;

import com.niit.housing.entity.AptLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptLocationRepository extends CrudRepository<AptLocation, Long> {
}

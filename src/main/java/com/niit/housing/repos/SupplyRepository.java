package com.niit.housing.repos;

import com.niit.housing.entity.ConsumableSupply;
import org.springframework.data.repository.CrudRepository;

public interface SupplyRepository extends CrudRepository<ConsumableSupply, Long> {
}

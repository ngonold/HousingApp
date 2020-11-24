package com.niit.housing.repos;

import com.niit.housing.entity.ConsumableSupply;
import com.niit.housing.enums.ConsumableType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepository extends CrudRepository<ConsumableSupply, Long> {
    List<ConsumableSupply> findConsumableSuppliesByApartmentIdAndAndConsumableType(Long apartmentId,
                                                                                   ConsumableType consumableType);
    List<ConsumableSupply> findConsumableSuppliesByApartmentId(Long apartmentId);
}

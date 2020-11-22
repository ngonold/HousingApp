package com.niit.housing.repos;

import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.AptLocation;
import com.niit.housing.entity.ConsumableSupply;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface ApartmentCustomRepository {
    Apartment saveApartmentWithAddress(Apartment apartment, AptLocation aptLocation);
    List<ConsumableSupply> fetchConsumptions(Apartment apartment);
}

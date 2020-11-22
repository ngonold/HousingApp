package com.niit.housing.repos.implementation;

import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.AptLocation;
import com.niit.housing.entity.ConsumableSupply;
import com.niit.housing.enums.ConsumableType;
import com.niit.housing.repos.ApartmentCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static com.niit.housing.enums.ConsumableType.GAS;
//DELETE ME
@Repository
public class ApartmentRepositoryImpl implements ApartmentCustomRepository {

    private final EntityManager entityManager;

    @Autowired
    public ApartmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Apartment saveApartmentWithAddress(Apartment apartment, AptLocation aptLocation) {
        entityManager.persist(apartment);
        apartment.setAptLocation(aptLocation);
        return apartment;
    }

    @Override
    public List<ConsumableSupply> fetchConsumptions(Apartment apartment) {

        if (!entityManager.contains(apartment)) {
            apartment = entityManager.merge(apartment);
        }
        Query query = entityManager.createQuery("SELECT suppliesConsumption FROM Apartment apartment " +
                "left join fetch apartment.suppliesConsumption suppliesConsumption where apartment =: apartment");
        return query.setParameter("apartment", apartment).getResultList();
    }


}

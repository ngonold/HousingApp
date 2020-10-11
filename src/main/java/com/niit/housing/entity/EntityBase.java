package com.niit.housing.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
abstract class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
}

package com.niit.housing.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "apartment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Apartment extends EntityBase {
    @Column(name = "telephone_number")
    private String telephoneNumber;
    @Column(name = "account_number")
    private int accountNumber;
    //private SuppliesConsumption suppliesConsumption;
    @OneToOne(fetch = FetchType.LAZY)
    private AptLocation aptLocation;
}

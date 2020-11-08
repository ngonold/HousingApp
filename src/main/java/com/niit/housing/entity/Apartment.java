package com.niit.housing.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "apartment")
    private List<ConsumableSupply> suppliesConsumption = new ArrayList<>();

    @OneToOne(mappedBy = "apartment")
    private AptLocation aptLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;
}

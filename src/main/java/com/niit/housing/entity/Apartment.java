package com.niit.housing.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "apartment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "suppliesConsumption")
@ToString(callSuper = true)
@AttributeOverrides(@AttributeOverride(name = "id", column = @Column(name = "apt_id")))
public class Apartment extends EntityBase {
    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "account_number")
    private Integer accountNumber;

    @OneToMany(mappedBy = "apartment")
    private Collection<ConsumableSupply> suppliesConsumption = new ArrayList<>();

    @OneToOne(mappedBy = "apartment", cascade = {CascadeType.ALL})
    private AptLocation aptLocation;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "owner_id")
    private User owner;
}

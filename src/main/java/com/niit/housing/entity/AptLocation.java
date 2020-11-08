package com.niit.housing.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "apartment")
@ToString(callSuper = true)
public class AptLocation extends EntityBase{
    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String houseNumber;

    @Column(name = "porch")
    private String porchNumber;

    @Column(name = "floor")
    private String floorNumber;

    @Column(name = "number")
    private String aptNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aptLocation")
    private Apartment apartment;
}

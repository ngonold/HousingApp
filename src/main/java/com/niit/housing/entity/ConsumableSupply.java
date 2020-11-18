package com.niit.housing.entity;

import com.niit.housing.entity.Apartment;
import com.niit.housing.entity.EntityBase;
import com.niit.housing.enums.ConsumableType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "consumptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumableSupply extends EntityBase {
    @Column(name = "value")
    private Integer value;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ConsumableType consumableType;

    @Column(name = "month")
    private Month month;

    @Column(name = "year")
    private Year year;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    Apartment apartment;
}

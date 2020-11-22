package com.niit.housing.entity;

import com.niit.housing.enums.ConsumableType;
import lombok.*;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Table(name = "consumptions")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"apartment"}, callSuper = true)
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
    @JoinColumn(name = "apt_id")
    Apartment apartment;
}

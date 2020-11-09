package com.niit.housing.entity;

import com.niit.housing.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
//Just to show how to hide SQL keywords (user, order, etc...) within JPA
@Table(name = "\"users\"")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends EntityBase {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "email")
    private String email;

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "owner")
    private Collection<Apartment> apartments = new HashSet<>();
}

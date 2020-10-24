package com.niit.housing.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
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
}

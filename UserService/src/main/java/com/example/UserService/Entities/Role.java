package com.example.UserService.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {
    @Id
    @Column(name="id")
    Long id;

    @Column(name = "name")
    String roleName;
}

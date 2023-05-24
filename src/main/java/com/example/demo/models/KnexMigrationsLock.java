package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "knex_migrations_lock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnexMigrationsLock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;

    @Column(name = "is_locked")
    private Integer isLocked;

}
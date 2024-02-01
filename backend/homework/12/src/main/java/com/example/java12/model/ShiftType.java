package com.example.java12.model;

import lombok.Data;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "shift_types")
public class ShiftType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Type uniqueName;

    private String description;

    private boolean active;

    @Column(length = 32)
    private String timeZone;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tenant tenant;

    public enum Type {
        MORNING,
        AFTERNOON,
        EVENING
    }
}
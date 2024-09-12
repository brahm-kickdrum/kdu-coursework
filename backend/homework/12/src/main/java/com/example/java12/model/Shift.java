package com.example.java12.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Shift extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    private ShiftType shiftType;

    @Column(length = 128)
    private String name;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private LocalTime timeStart;

    private LocalTime endTime;

    @Column(length = 32)
    private String timeZone;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tenant tenant;
}

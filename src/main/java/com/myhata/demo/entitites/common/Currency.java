package com.myhata.demo.entitites.common;


import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "currency")
@NoArgsConstructor
public class Currency {

    @Id
    @SequenceGenerator(name = "currency_id", sequenceName = "currency_seq_id", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_id")
    Long id;

    @NonNull
    private String code;

    @NonNull
    private String description;
}

package com.myhata.demo.entitites.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product_group")
public class ProductGroup {

    @Id
    @SequenceGenerator(name = "product_group_id", sequenceName = "product_group_seq_id", initialValue = 1)
    @GeneratedValue(generator = "product_group_seq_id", strategy = GenerationType.SEQUENCE)
    Long id;

    @NonNull
    String code;

    @NonNull
    String description;
}
package com.myhata.demo.entitites.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @SequenceGenerator(name = "product_id", sequenceName = "product_seq_id")
    @GeneratedValue(generator = "product_seq_id", strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroup;

    @NonNull
    String code;

    @NonNull
    String description;

}

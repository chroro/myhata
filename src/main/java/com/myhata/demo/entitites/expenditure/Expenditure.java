package com.myhata.demo.entitites.expenditure;

import com.myhata.demo.entitites.product.Product;
import com.myhata.demo.entitites.user.UserTaskHistory;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Currency;

@Entity
@Data
@NoArgsConstructor
@Table(name = "expenditure")
public class Expenditure {
    @Id
    @SequenceGenerator(name = "expenditure_id", sequenceName = "expenditure_seq_id", initialValue = 1)
    @GeneratedValue(generator = "expenditure_seq_id",strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "product_id")
    private Product product;

    private BigDecimal amount;

    private boolean paid;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar paymentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_task_history_id")
    private UserTaskHistory userTaskHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "currency_id")
    private Currency currency;
}
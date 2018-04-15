package com.myhata.demo.entitites.dept;

import com.myhata.demo.entitites.expenditure.Expenditure;
import com.myhata.demo.entitites.user.User;
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
@Table(name = "dept")
public class Dept {
    @Id
    @SequenceGenerator(name = "dept_id", sequenceName = "dept_seq_id", initialValue = 1 )
    @GeneratedValue(generator = "dept_seq_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String reason;

    private String taskName;

    private boolean yourDept;

    private boolean paid;

    @NonNull
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Expenditure expenditure;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateRecieved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "currency_id")
    private Currency currency;
}
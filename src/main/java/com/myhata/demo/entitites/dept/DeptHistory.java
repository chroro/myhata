package com.myhata.demo.entitites.dept;

import com.myhata.demo.entitites.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dept_history")
public class DeptHistory {

    @Id
    @SequenceGenerator(name = "dept_history_id", sequenceName = "dept_history_seq_id")
    @GeneratedValue(generator = "dept_history_seq_id")
    private Long id;

    @NonNull
    private BigDecimal amountPaid;

    @NonNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @NonNull
    private Calendar paymentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Dept dept;
}

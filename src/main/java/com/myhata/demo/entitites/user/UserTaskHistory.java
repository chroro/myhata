package com.myhata.demo.entitites.user;

import com.myhata.demo.entitites.expenditure.Expenditure;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_task_history")
public class UserTaskHistory {

    @Id
    @SequenceGenerator(name = "user_task_history_id", sequenceName = "user_task_history_seq_id", initialValue = 1)
    @GeneratedValue(generator = "user_task_history_seq_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateStart;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserTask userTask;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Expenditure> expenditures;

    @NonNull
    private BigDecimal totalAmount;
}

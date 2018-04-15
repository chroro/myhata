package com.myhata.demo.entitites.user;

import com.myhata.demo.entitites.common.Status;
import com.myhata.demo.entitites.expenditure.Expenditure;
import com.myhata.demo.entitites.task.Task;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_task")
public class UserTask {

    @Id
    @SequenceGenerator(name = "user_task_id", sequenceName = "user_task_seq_id", initialValue = 1)
    @GeneratedValue(generator = "user_task_seq_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "task_id")
    @NonNull
    private Task task;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_id")
    @NonNull
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endDate;  // the time when status is set to Archived

    private Integer priority;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Expenditure> expenditures;

    @NonNull
    private Status status;

    private Boolean supports;

    private Boolean against;

}

package com.myhata.demo.entitites.task;

import com.myhata.demo.entitites.common.Period;
import com.myhata.demo.entitites.common.Status;
import com.myhata.demo.entitites.user.UserTask;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "task_id")
public class Task {

    @Id
    @SequenceGenerator(name = "task_id", sequenceName = "task_seq_id", initialValue = 1)
    @GeneratedValue(generator = "task_seq_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String name;

    private String description;

    @NonNull
    private Status status;

    @NonNull
    private Period period;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<UserTask> userTasks;

    private Integer supports;

    private Integer against;

    private Boolean random; // if true randomly sets the order of users

    //TODO add field user created

    public void incrementSupport() {
        this.supports ++;
    }

    public void incrementAgainst() {
        this.against ++;
    }
}



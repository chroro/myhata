package com.myhata.demo.entitites.user;

import com.myhata.demo.entitites.dept.Dept;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(name = "user_id", sequenceName = "user_seq_id", initialValue = 1)
    @GeneratedValue(generator = "user_seq_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Dept> depts;
}

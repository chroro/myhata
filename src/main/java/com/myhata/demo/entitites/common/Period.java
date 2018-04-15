package com.myhata.demo.entitites.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@Table(name = "period")
public class Period {

    @Id
    @SequenceGenerator(name = "period_id", sequenceName = "period_seq_id", initialValue = 1)
    @GeneratedValue(generator = "period_seq_id", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;

    private Integer step;

    private Boolean periodic;

    private Measurement measurement; // not null

    public enum Measurement {
        HOUR,
        DAY,
        MONTH
    }
}

package com.myhata.demo.entitites.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

public enum Status {
        ACTIVE,
        ARCHIVED,
        PENDING,
        WAITING,
        REJECTED
}


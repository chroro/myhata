package com.myhata.demo.pojos.requests;

import lombok.Data;

@Data
public class VoteRequest {
    private Long taskId;
    private Long userId; //TODO we get user ID from the DB.
    private boolean supports;
}

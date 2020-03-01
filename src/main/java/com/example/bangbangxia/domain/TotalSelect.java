package com.example.bangbangxia.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TotalSelect {

    private Integer user_id;
    private Integer accept_userId;
    private Integer task_state;
}

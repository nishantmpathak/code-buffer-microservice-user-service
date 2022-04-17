package com.asymptote.user.VO;

import com.asymptote.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObjectVO {

    private User user;
    private Department department;
}

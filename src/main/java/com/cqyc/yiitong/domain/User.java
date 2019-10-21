package com.cqyc.yiitong.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author: cqyc
 * Description:
 * Created by cqyc on 19-10-8
 */
@Data
public class User {
    private String username;

    @JsonIgnore
    private String password;
}

package com.shun.ebook.admin.controller.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * shun
 * 2019-08-07
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserReq {

    private String name;
    private String password;
    private String email;

}

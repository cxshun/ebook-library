package com.shun.ebook.admin.controller.sys.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cxshun@gmail.com
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

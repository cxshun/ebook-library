package com.shun.ebook.admin.controller.sys.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cxshun@gmail.com
 * 2019-08-08 14-49
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserReq {

    private Long id;
    private String name;
    private String email;
    private String password;

}

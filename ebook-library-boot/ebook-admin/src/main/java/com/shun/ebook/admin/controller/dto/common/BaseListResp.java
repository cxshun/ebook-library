package com.shun.ebook.admin.controller.dto.common;

import com.shun.ebook.common.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author cxshun@gmail.com
 * 2019-08-08 14-56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseListResp<T> {

    private List<T> list;
    private PageInfo page;

}

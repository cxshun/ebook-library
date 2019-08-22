package com.shun.ebook.admin.common;

import com.alibaba.fastjson.JSON;
import com.shun.ebook.common.CommonResponse;
import com.shun.ebook.common.MessageCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author cxshun@gmail.com
 * 2019-08-12 18-12
 **/
@Slf4j
@SuppressWarnings("NullableProblems")
@ControllerAdvice
public class RestControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        CommonResponse commonResponse = new CommonResponse(o, MessageCode.SUCCESS.getCode(), MessageCode.SUCCESS.getDesc());
        log.info(JSON.toJSONString(commonResponse));

        return commonResponse;
    }
}

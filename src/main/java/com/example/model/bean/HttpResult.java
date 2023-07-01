package com.example.model.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HttpResult {
    // 返回给前端的自定义的响应码
    private Integer code;
    // 返回给前端的消息
    private String msg;
    // 返回给前端的数据
    private Object data;
}

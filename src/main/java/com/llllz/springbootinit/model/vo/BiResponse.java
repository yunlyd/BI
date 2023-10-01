package com.llllz.springbootinit.model.vo;

/**
 * @create 2023-09-30-16:55
 * Bi 的返回结果
 */

import lombok.Data;

@Data
public class BiResponse {

    private String genChart;

    private String genResult;
    // 新生成的图标id
    private Long chartId;
}
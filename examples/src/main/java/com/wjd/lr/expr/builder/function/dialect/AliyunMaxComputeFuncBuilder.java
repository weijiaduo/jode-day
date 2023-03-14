package com.wjd.lr.expr.builder.function.dialect;

import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.model.Function;

/**
 * Aliyun MaxCompute
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class AliyunMaxComputeFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String day(Function function) {
        return formatDate(function, "DD");
    }

    @Override
    public String month(Function function) {
        return formatDate(function, "MM");
    }

    @Override
    public String year(Function function) {
        return formatDate(function, "YYYY");
    }

    /**
     * 格式化日期
     *
     * @param function   函数
     * @param dateFormat 格式化字符串
     * @return 日期字符串
     */
    private String formatDate(Function function, String dateFormat) {
        String p1 = function.getParams().get(0);
        return String.format("cast(to_char(%s, %s) as bigint)", p1, dateFormat);
    }

}

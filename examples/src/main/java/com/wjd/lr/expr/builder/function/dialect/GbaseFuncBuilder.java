package com.wjd.lr.expr.builder.function.dialect;

import com.wjd.lr.expr.builder.function.GeneralFuncBuilder;
import com.wjd.lr.expr.model.Function;

/**
 * Gbase
 *
 * @author weijiaduo
 * @since 2023/3/10
 */
public class GbaseFuncBuilder extends GeneralFuncBuilder {

    @Override
    public String getDate(Function function) {
        return buildDefault(new Function("now", function.getParams()));
    }

}

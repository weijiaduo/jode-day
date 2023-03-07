package com.wjd.lr.expr;

import com.wjd.lr.expr.antlr.ExprParser;
import com.wjd.lr.expr.antlr.ExprParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 表达式语法树访问者
 *
 * @author weijiaduo
 * @since 2023/3/7
 */
public class ExprVisitor extends ExprParserBaseVisitor<String> {

    /**
     * 规则节点处理器
     */
    private final Map<String, RuleHandler<?, String>> ruleHandlers = new HashMap<>();

    /**
     * 注册处理器
     *
     * @param name        处理器名称
     * @param ruleHandler 规则处理器
     */
    public void registerHandler(String name, RuleHandler<?, String> ruleHandler) {
        ruleHandlers.put(name, ruleHandler);
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        StringBuilder sb = new StringBuilder();
        if (aggregate != null) {
            sb.append(aggregate);
        }
        if (nextResult != null) {
            sb.append(nextResult);
        }
        return sb.toString();
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        String expr = node.getText();
        if ("<EOF>".equals(expr)) {
            return "";
        }
        return expr;
    }

    @Override
    public String visitLiteral(ExprParser.LiteralContext ctx) {
        return ctx.getText();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String visitTemplate(ExprParser.TemplateContext ctx) {
        RuleHandler<ExprParser.TemplateContext, String> handler =
                (RuleHandler<ExprParser.TemplateContext, String>) ruleHandlers.get("template");
        return handler.handle(ctx);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String visitColumnRef(ExprParser.ColumnRefContext ctx) {
        RuleHandler<ExprParser.ColumnRefContext, String> handler =
                (RuleHandler<ExprParser.ColumnRefContext, String>) ruleHandlers.get("column_ref");
        return handler.handle(ctx);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String visitGeneralFunc(ExprParser.GeneralFuncContext ctx) {
        RuleHandler<ExprParser.GeneralFuncContext, String> handler =
                (RuleHandler<ExprParser.GeneralFuncContext, String>) ruleHandlers.get("general_func");
        return handler.handle(ctx);
    }

    @Override
    public String visitNativeFunc(ExprParser.NativeFuncContext ctx) {
        String expr = super.visitNativeFunc(ctx);
        if (expr != null && expr.length() > 1) {
            // remove symbol @
            expr = expr.substring(1);
        } else {
            expr = "";
        }
        return expr;
    }

    @Override
    public String visitAnyName(ExprParser.AnyNameContext ctx) {
        return ctx.getText();
    }

}

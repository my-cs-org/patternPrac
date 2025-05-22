package com.ohgiraffers.pattern.chap03.behavioral.section03.interpreter;

/**
 * 설명. 인터프리터 패턴의 비종결 표현식(Non-terminal Expression) 클래스
 *  - 뺄셈 연산을 처리하는 표현식
 */
public class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}

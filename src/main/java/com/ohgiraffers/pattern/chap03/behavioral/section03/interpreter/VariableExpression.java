package com.ohgiraffers.pattern.chap03.behavioral.section03.interpreter;

/**
 * 설명. 인터프리터 패턴의 종결 표현식(Terminal Expression) 클래스
 *  - 변수를 나타내는 표현식
 */
public class VariableExpression implements Expression {
    private String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getVariable(name);
    }
}

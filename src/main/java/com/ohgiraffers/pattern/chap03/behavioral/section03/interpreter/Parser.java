package com.ohgiraffers.pattern.chap03.behavioral.section03.interpreter;

import java.util.Stack;

/**
 * 설명. 인터프리터 패턴의 파서(Parser) 클래스
 *  - 입력된 표현식을 파싱하여 표현식 객체 트리를 생성
 */
public class Parser {
    /**
     * 설명. 후위 표기법(Postfix) 형태의 문자열을 파싱하여 표현식 트리 생성
     *      (예: "a b +"는 a + b를 의미)
     */
    public Expression parse(String expression) {
        Stack<Expression> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperator(token)) {
                
                /* 설명. 연산자인 경우 */
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(createOperatorExpression(token, left, right));
            } else {

                if (isNumber(token)) {

                    /* 설명. 숫자인 경우 */
                    stack.push(new NumberExpression(Integer.parseInt(token)));
                } else {

                    /* 설명. 변수인 경우 */
                    stack.push(new VariableExpression(token));
                }
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*");
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Expression createOperatorExpression(String operator, Expression left, Expression right) {
        switch (operator) {
            case "+":
                return new AddExpression(left, right);
            case "-":
                return new SubtractExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자: " + operator);
        }
    }
}

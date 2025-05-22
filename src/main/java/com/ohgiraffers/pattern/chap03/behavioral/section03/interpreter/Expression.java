package com.ohgiraffers.pattern.chap03.behavioral.section03.interpreter;

/**
 * 설명. 인터프리터 패턴의 추상 표현(Expression) 인터페이스
 *  - 구문 트리의 모든 노드에 대한 공통 인터페이스 정의
 */
public interface Expression {
    int interpret(Context context);
}

package com.ohgiraffers.pattern.chap02.structural.section04.decorator;

/**
 * 설명. 구체 컴포넌트 - 데코레이터가 장식할 기본 객체
 */
public class ConcreteComponent implements Component{
    @Override
    public String operation() {
        return "기본 컴포넌트";
    }
}

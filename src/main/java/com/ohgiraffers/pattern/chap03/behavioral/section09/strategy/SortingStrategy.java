package com.ohgiraffers.pattern.chap03.behavioral.section09.strategy;

/**
 * 설명. 전략 패턴의 전략(Strategy) 인터페이스
 *  - 알고리즘 계열을 정의하는 인터페이스
 */
public interface SortingStrategy {
    void sort(int[] array);
    
    /* 설명. 전략의 이름 반환 */
    String getName();
}

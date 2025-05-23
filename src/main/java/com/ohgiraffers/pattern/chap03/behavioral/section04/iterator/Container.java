package com.ohgiraffers.pattern.chap03.behavioral.section04.iterator;

/**
 * 설명. 이터레이터 패턴의 컨테이너 인터페이스
 *  - 이터레이터 생성 메소드 정의
 */
public interface Container<T> {
    Iterator<T> createIterator();
}

package com.ohgiraffers.pattern.chap03.behavioral.section04.iterator;

/**
 * 설명. 이터레이터 패턴의 이터레이터 인터페이스
 *  - 컬렉션의 요소에 순차적으로 접근하기 위한 인터페이스
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

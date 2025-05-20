package com.ohgiraffers.pattern.chap01.creational.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 구체적인 제품(Concrete Product) 클래스
 *  - Mac 스타일 텍스트 필드 구현
 */
public class MacTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Mac 스타일 텍스트 필드 렌더링");
    }

    @Override
    public void getText() {
        System.out.println("Mac 스타일 텍스트 필드에서 텍스트 가져옴");
    }
}

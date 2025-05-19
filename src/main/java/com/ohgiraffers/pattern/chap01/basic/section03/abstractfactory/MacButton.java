package com.ohgiraffers.pattern.chap01.basic.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 구체적인 제품(Concrete Product) 클래스
 *  - Mac 스타일 텍스트 필드 구현
 */
public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Mac 스타일 버튼 렌더링");
    }

    @Override
    public void onClick() {
        System.out.println("Mac 스타일 버튼 클릭");
    }
}

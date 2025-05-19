package com.ohgiraffers.pattern.chap01.basic.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 구체적인 제품(Concrete Product) 클래스
 *  - Windows 스타일 버튼 구현
 */
public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Windows 스타일 버튼 렌더링");
    }

    @Override
    public void onClick() {
        System.out.println("Windows 스타일 버튼 클릭");
    }
}

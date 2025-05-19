package com.ohgiraffers.pattern.chap01.basic.section03.abstractfactory;

/**
 * 설명. 추상 팩토리 패턴의 구체적인 제품(Concrete Product) 클래스
 *  - Windows 스타일 텍스트 필드 구현
 */
public class WindowsTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Windows 스타일 텍스트 필드 렌더링");
    }

    @Override
    public void getText() {
        System.out.println("Windows 스타일 텍스트 필드에서 텍스트 가져옴");
    }
}

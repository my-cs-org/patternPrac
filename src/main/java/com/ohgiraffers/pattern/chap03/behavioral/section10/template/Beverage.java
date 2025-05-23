package com.ohgiraffers.pattern.chap03.behavioral.section10.template;

/**
 * 설명. 템플릿 메소드 패턴의 추상 클래스
 *  - 알고리즘의 골격을 정의
 */
public abstract class Beverage {
    
    /* 설명. 템플릿 메소드 - 음료 준비 과정의 전체 알고리즘(final을 통한 오버라이딩 불가능) */
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
        hook();
    }
    
    /* 설명. 물 끓이기 - 공통 메소드 */
    private void boilWater() {
        System.out.println("물을 끓이는 중");
    }
    
    /* 설명. 컵에 따르기 - 공통 메소드 */
    private void pourInCup() {
        System.out.println("컵에 따르는 중");
    }
    
    /* 설명. 추출 방법 - 서브클래스가 구현해야 하는 추상 메소드 */
    protected abstract void brew();
    
    /* 설명. 첨가물 추가 - 서브클래스가 구현해야 하는 추상 메소드 */
    protected abstract void addCondiments();
    
    /* 설명. 후크(Hook) 메소드 - 서브클래스가 필요에 따라 오버라이딩 하는 선택적 메소드 */
    protected void hook() {

        /* 설명. 기본 구현은 아무것도 없음 */
    }
    
    /* 설명. 첨가물 추가 여부 확인 - 서브클래스에서 오버라이드 가능한 메소드 */
    protected boolean customerWantsCondiments() {
        return true;    // 기본적으로 첨가물 추가
    }
} 
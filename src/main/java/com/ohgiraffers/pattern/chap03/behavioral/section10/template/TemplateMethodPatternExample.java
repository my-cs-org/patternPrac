package com.ohgiraffers.pattern.chap03.behavioral.section10.template;

/**
 * 설명. 템플릿 메소드 패턴 사용 예제
 *  - 알고리즘의 골격을 정의하고 일부 단계를 서브클래스에서 구현하도록 함
 *  - 알고리즘의 구조를 변경하지 않고 특정 단계만 재정의 가능
 */
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 템플릿 메소드 패턴 예제 실행 =====");
        
        System.out.println("===== 커피 준비 =====");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
        
        System.out.println("===== 차 준비 =====");
        Beverage tea = new Tea();
        tea.prepareRecipe();
        
        /* 설명. 익명 클래스로도 사용 가능(사용자 입력 없는 방식) */
        System.out.println("===== 녹차 준비 (첨가물 없음) =====");
        Beverage greenTea = new Tea() {
            @Override
            protected boolean customerWantsCondiments() {
                return false; // 첨가물 추가하지 않음
            }
            
            @Override
            protected void brew() {
                System.out.println("녹차를 우려내는 중");
            }
            
            @Override
            protected void hook() {
                System.out.println("녹차가 준비되었습니다. 맛있게 드세요!");
            }
        };
        greenTea.prepareRecipe();
    }
} 
package com.ohgiraffers.pattern.chap03.behavioral.section10.template;

/**
 * 설명. 템플릿 메소드 패턴 사용 예제
 *  - 알고리즘의 골격을 정의하고 일부 단계를 서브클래스에서 구현하도록 함
 *  - 알고리즘의 구조를 변경하지 않고 특정 단계만 재정의 가능
 *
 * 설명. 템플릿 메소드 패턴의 장점
 *  1. 코드 재사용: 공통 알고리즘 구조를 상위 클래스에서 정의하여 중복 코드 감소
 *  2. 유연한 확장: 알고리즘의 특정 단계만 서브클래스에서 재정의 가능
 *  3. 제어의 역전(IoC): 상위 클래스가 알고리즘의 흐름을 제어하고 하위 클래스는 세부 구현에 집중
 *  4. 변경의 국소화: 알고리즘 구조 변경 시 상위 클래스만 수정하면 됨
 *
 * 설명. 템플릿 메소드 패턴의 단점
 *  1. 상속의 제약: 상속을 사용하므로 상속의 단점을 그대로 가짐
 *  2. 알고리즘 구조 변경의 어려움: 전체 알고리즘 구조 변경 시 상위 클래스 수정 필요
 *  3. 하위 클래스 제한: 상위 클래스에서 정의한 알고리즘 구조를 따라야 함
 *  4. 템플릿 메소드가 복잡해질 경우 유지보수 어려움
 *
 * 설명. 적절한 사용처
 *  1. 여러 클래스에서 공통된 알고리즘 구조를 가질 때
 *  2. 알고리즘의 뼈대는 동일하나 세부 구현이 다른 경우
 *  3. 프레임워크 개발: 확장 지점을 제공하면서 기본 동작 정의
 *  4. 코드 중복을 줄이고 공통 로직을 추상화해야 할 때
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
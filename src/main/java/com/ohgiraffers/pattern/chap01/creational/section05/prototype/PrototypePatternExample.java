package com.ohgiraffers.pattern.chap01.creational.section05.prototype;

/**
 * 설명. 프로토타입 패턴 사용 예제
 *  - 기존 객체를 복제하여 새로운 객체 생성
 *  - 객체 생성 비용이 큰 경우 효율적
 *  
 * 설명. 프로토타입 패턴의 장점
 *  1. 복잡한 객체를 처음부터 생성하지 않고 복제하여 비용 절감
 *  2. 런타임에 객체 타입을 동적으로 결정 가능
 *  3. 객체 생성 과정이 복잡한 경우 단순화 가능
 *  4. 객체 생성을 서브클래스에 위임하지 않고도 확장 가능
 *  
 * 설명. 프로토타입 패턴의 단점
 *  1. 깊은 복사(Deep Copy)를 구현하기 어려울 수 있음
 *  2. 순환 참조가 있는 복잡한 객체의 경우 복제가 어려움
 *  3. 복제 과정에서 생성자 호출을 피할 수 없는 경우가 있음
 *  
 * 설명. 적절한 사용처
 *  1. 객체 생성 비용이 큰 경우
 *  2. 유사한 객체를 많이 생성해야 하는 경우
 *  3. 객체 생성 시 DB 접근 등 비용이 많이 드는 작업을 줄이고 싶을 때
 *  4. 런타임에 객체 타입을 결정해야 하는 경우
 */
public class PrototypePatternExample {
    public static void main(String[] args) {
        System.out.println("===== 프로토타입 패턴 예제 실행 =====");

        /* 설명. 도형 캐시 로드 */
        ShapeCache.loadCache();

        System.out.println("===== 원본 객체로부터 새로운 객체 복제 =====");
        
        /* 설명. ID가 "1"인 원 복제 */
        Shape clonedCircle = ShapeCache.getShape("1");
        System.out.println("ID가 \"1\"인 도형 타입: " + clonedCircle.getType());
        clonedCircle.draw();

        /* 설명. ID가 "2"인 사각형 복제 */
        Shape clonedRectangle = ShapeCache.getShape("2");
        System.out.println("ID가 \"2\"인 도형 타입: " + clonedRectangle.getType());
        clonedRectangle.draw();

        /* 설명. ID가 "3"인 원 복제 */
        Shape clonedCircle2 = ShapeCache.getShape("3");
        System.out.println("ID가 \"3\"인 도형 타입: " + clonedCircle2.getType());
        clonedCircle2.draw();

        /* 설명. ID가 "1"인 복제된 원 객체 수정 예시 */
        System.out.println("===== 복제된 객체 수정 =====");
        Circle circle = (Circle) clonedCircle;
        circle.setRadius(15);
        circle.setColor("노랑");
        System.out.println("수정된 원:");
        circle.draw();

        /* 설명. 다시 ID가 "1"인 원 복제(원본 원에 해당) */
        Shape originalCircle = ShapeCache.getShape("1");
        System.out.println("원본 원 (영향 없음):");
        originalCircle.draw();
    }
}

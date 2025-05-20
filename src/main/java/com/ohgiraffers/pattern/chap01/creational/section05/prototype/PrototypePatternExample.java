package com.ohgiraffers.pattern.chap01.creational.section05.prototype;

/**
 * 설명. 프로토타입 패턴 사용 예제
 *  - 기존 객체를 복제하여 새로운 객체 생성
 *  - 객체 생성 비용이 큰 경우 효율적
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

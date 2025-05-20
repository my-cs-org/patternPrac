package com.ohgiraffers.pattern.chap01.creational.section01.singleton;

/**
 * 설명. 싱글톤 패턴 사용 예제
 *  - 애플리케이션 전체에서 하나의 인스턴스만 존재하며 전역 접근이 가능하면서도
 *    추가 인스턴스 생성을 제한하는 것을 확인할 수 있다.
 *
 * 설명. 싱글톤 패턴의 장점:
 *  1. 인스턴스가 한 번만 생성되므로 메모리 낭비 방지
 *  2. 전역 인스턴스이므로 다른 클래스의 인스턴스들이 접근하여 데이터 공유 가능
 *  3. 인스턴스 생성 비용이 큰 경우 효율적
 *
 * 설명. 싱글톤 패턴의 단점:
 *  1. 멀티스레드 환경에서 동기화 문제가 발생할 수 있음
 *  2. 테스트가 어려울 수 있음(전역 상태로 인한 의존성 문제로 싱글톤 객체가 테스트간에 공유되어 영향을 줄 수 있음)
 *  3. private 생성자로 인한 상속 불가능
 */
public class SingletonPatternExample {
    public static void main(String[] args) {

        System.out.println("=====싱글톤 패턴 예제 실행=====");
//        new Singleton();      // private 생성자라 직접 인스턴스 생성 불가

        System.out.println("===== 1st getInstance =====");
        Singleton instance1 = Singleton.getInstance();

        System.out.println("===== 2st getInstance =====");
        Singleton instance2 = Singleton.getInstance();

        System.out.println("===== 두 인스턴스가 동일한지 확인 =====");
        System.out.println("instance1 == instance2: " + (instance1 == instance2));

        System.out.println("===== 주소 확인(hashCode) =====");
        System.out.println("instance1 해시코드: " + instance1.hashCode());
        System.out.println("instance2 해시코드: " + instance2.hashCode());
    }
}

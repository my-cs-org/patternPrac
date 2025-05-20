package com.ohgiraffers.pattern.chap01.creational.section01.singleton;


/**
 * 설명. 싱글톤 패턴의 기본 클래스
 *  - 전체 시스템에서 오직 하나의 인스턴스만 존재하도록 보장
 */
public class Singleton {

    /* 설명. 유일한 인스턴스를 저장할 정적 변수 */
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton 인스턴스가 생성 됨");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /* 설명. 싱글톤 객체의 예시 기능 */
    public void doSomething() {
        System.out.println("싱글톤 객체의 작업 수행 시작");
    }
}

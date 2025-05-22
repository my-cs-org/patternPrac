package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 커맨드 패턴의 수신자(Receiver) 클래스
 *  - 실제 작업을 수행하는 객체
 */
public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " 조명이 켜졌습니다.");
    }

    public void off() {
        System.out.println(location + " 조명이 꺼졌습니다.");
    }
}

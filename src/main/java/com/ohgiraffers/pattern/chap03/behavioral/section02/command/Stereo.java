package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 커맨드 패턴의 수신자(Receiver) 클래스
 *  - 실제 작업을 수행하는 객체
 */
public class Stereo {
    private String location;
    private int volume;

    public Stereo(String location) {
        this.location = location;
//        this.volume = 0;
    }

    public void on() {
        System.out.println(location + " 스테레오가 켜졌습니다.");
    }

    public void off() {
        System.out.println(location + " 스테레오가 꺼졌습니다.");
    }

    public void setCD() {
        System.out.println(location + " 스테레오가 CD 모드로 설정되었습니다.");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " 스테레오 볼륨이 " + volume + "로 설정되었습니다.");
    }

    public int getVolume() {
        return volume;
    }
}

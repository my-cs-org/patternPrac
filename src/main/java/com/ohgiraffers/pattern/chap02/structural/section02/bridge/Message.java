package com.ohgiraffers.pattern.chap02.structural.section02.bridge;

/**
 * 설명. 브릿지 패턴의 추상화(Abstraction) 클래스
 *  - 메시지의 기본 구조와 전송 방식 정의
 */
public abstract class Message {
    protected MessageSender messageSender;

    public Message(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void send(String recipient);
}

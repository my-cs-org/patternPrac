package com.ohgiraffers.pattern.chap02.structural.section02.bridge;

/**
 * 설명. 브릿지 패턴의 구체적인 추상화(Refined Abstraction) 클래스
 *  - 일반 텍스트 메시지 구현
 */
public class TextMessage extends Message {
    private String text;

    public TextMessage(MessageSender messageSender, String text) {
        super(messageSender);
        this.text = text;
    }

    @Override
    public void send(String recipient) {
        messageSender.sendMessage(recipient, text);
    }
}

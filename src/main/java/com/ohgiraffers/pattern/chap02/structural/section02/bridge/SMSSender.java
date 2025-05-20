package com.ohgiraffers.pattern.chap02.structural.section02.bridge;

/**
 * 설명. 브릿지 패턴의 구체적인 구현부(Concrete Implementor) 클래스
 *  - SMS를 통한 메시지 전송 구현
 */
public class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS 발송: [" + recipient + "]님에게 '" + message + "' 문자 전송");
    }
}

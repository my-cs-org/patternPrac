package com.ohgiraffers.pattern.chap02.structural.section02.bridge;

/**
 * 설명. 브릿지 패턴의 구체적인 구현부(Concrete Implementor) 클래스
 *  - 이메일을 통한 메시지 전송 구현
 */
public class EmailSender implements MessageSender{
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("이메일 발송: [" + recipient + "]님에게 '" + message + "' 메일 발송");
    }
}

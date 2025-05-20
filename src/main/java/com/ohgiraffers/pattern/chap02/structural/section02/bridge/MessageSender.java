package com.ohgiraffers.pattern.chap02.structural.section02.bridge;

/**
 * 설명. 브릿지 패턴의 구현부(Implementor) 인터페이스
 *  - 메시지를 보내는 다양한 방법 정의
 */
public interface MessageSender {
    void sendMessage(String message, String recipient);
}

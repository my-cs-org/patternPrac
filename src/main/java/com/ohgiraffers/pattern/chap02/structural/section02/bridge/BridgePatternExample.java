package com.ohgiraffers.pattern.chap02.structural.section02.bridge;


/**
 * 설명. 브릿지 패턴 사용 예제
 *  - 추상화와 구현을 분리하여 독립적으로 변형과 확장이 가능하게 함
 *  - 구현부에 직접 의존하지 않고 추상화된 인터페이스를 통해 연결
 *  
 * 설명. 브릿지 패턴의 장점
 *  1. 메시지 유형(추상화)과 전송 방법(구현)을 독립적으로 확장 가능
 *  2. 새로운 메시지 유형이나 전송 방법 추가가 용이함
 *  3. 클라이언트 코드 변경 없이 새 기능 추가 가능
 */
public class BridgePatternExample {
    public static void main(String[] args) {
        System.out.println("===== 브릿지 패턴 예제 실행 =====");

        /* 설명. 구현부 객체 생성 */
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        /* 설명. Message와 MessageSender라는 추상화된 인터페이스로 다룸 */
        /* 설명. 이메일을 통한 메시지 전송 */
        System.out.println("===== 이메일 전송 =====");
        Message textEmailMessage = new TextMessage(emailSender, "회의 안내입니다.");
        textEmailMessage.send("hong@hello.com");

        Message urgentEmailMessage = new UrgentMessage(emailSender, "서버 장애 발생!");
        urgentEmailMessage.send("admin@hello.com");
        
        /* 설명. SMS를 통한 메시지 전송 */
        System.out.println("===== SMS 전송 =====");
        Message textSmsMessage = new TextMessage(smsSender, "안녕하세요.");
        textSmsMessage.send("010-1234-5678");

        Message urgentSmsMessage = new UrgentMessage(smsSender, "비상 대피 요청!");
        urgentSmsMessage.send("010-1111-2222");
    }
}

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
 *  
 * 설명. 브릿지 패턴의 단점
 *  1. 코드 구조가 복잡해질 수 있음
 *  2. 추상화와 구현을 분리하기 위한 인터페이스 계층이 증가
 *  3. 설계 초기에 패턴을 적용하지 않으면 나중에 리팩토링하기 어려움
 *  
 * 설명. 적절한 사용처
 *  1. 추상화와 구현을 영구적으로 묶지 않고 독립적으로 변경하고 싶을 때
 *  2. 추상화와 구현이 런타임에 바뀔 수 있을 때
 *  3. 여러 플랫폼에서 사용할 컴포넌트를 개발할 때
 *  4. 기능과 플랫폼 간의 매트릭스가 있는 경우(여러 기능 x 여러 플랫폼)
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

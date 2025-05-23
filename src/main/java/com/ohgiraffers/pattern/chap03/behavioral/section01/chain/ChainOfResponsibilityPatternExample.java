package com.ohgiraffers.pattern.chap03.behavioral.section01.chain;

import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.supports.BillingSupport;
import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.supports.FrontDeskSupport;
import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.supports.LegalSupport;
import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.supports.TechnicalSupport;

/**
 * 설명. 책임 연쇄 패턴 사용 예제
 *  - 요청을 처리할 수 있는 객체가 여러 개일 때, 요청을 처리할 객체를 동적으로 결정
 *  
 * 설명. 책임 연쇄 패턴의 장점
 *  1. 요청의 발신자와 수신자를 분리
 *  2. 객체들 간의 결합도를 낮춤
 *  3. 요청 처리 객체를 동적으로 변경 가능
 *  4. 새로운 처리 객체를 쉽게 추가 가능
 */
public class ChainOfResponsibilityPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 책임 연쇄 패턴 예제 실행 =====");
        
        /* 설명. 지원팀 체인 구성 */
        SupportHandler frontDesk = new FrontDeskSupport();
        SupportHandler technicalSupport = new TechnicalSupport();
        SupportHandler billingSupport = new BillingSupport();
        SupportHandler legalSupport = new LegalSupport();

        /* 설명. 처리 체인 연결: 프론트 데스크 -> 기술 지원팀 -> 결제 지원팀 -> 법무팀 */
        frontDesk.setNext(technicalSupport).setNext(billingSupport).setNext(legalSupport);
        
        /* 설명. 다양한 고객 문의 생성 */
        SupportRequest request1 = new SupportRequest(
                SupportRequest.LEVEL_BASIC, "계정에 로그인할 수 없어요.");

        SupportRequest request2 = new SupportRequest(
                SupportRequest.LEVEL_TECHNICAL, "앱이 계속 충돌합니다.");

        SupportRequest request3 = new SupportRequest(
                SupportRequest.LEVEL_BILLING, "환불 처리가 안 되고 있어요.");

        SupportRequest request4 = new SupportRequest(
                SupportRequest.LEVEL_LEGAL, "개인정보 처리방침에 대해 문의하고 싶습니다.");

        SupportRequest request5 = new SupportRequest(
                5, "우주선을 구매하고 싶습니다.");          // 처리할 수 없는 요청
        
        /* 설명. 각 요청 처리 */
        System.out.println("===== 요청 1 처리 =====");
        frontDesk.handleRequest(request1);

        System.out.println("===== 요청 2 처리 =====");
        frontDesk.handleRequest(request2);

        System.out.println("===== 요청 3 처리 =====");
        frontDesk.handleRequest(request3);

        System.out.println("===== 요청 4 처리 =====");
        frontDesk.handleRequest(request4);

        System.out.println("===== 요청 5 처리 (처리 불가) =====");
        frontDesk.handleRequest(request5);
    }
}

package com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem;

/** 
 * 설명. 결재 처리 서브시스템 
 */
public class PaymentService {
    public boolean processPayment(String customerId, double amount) {
        System.out.println("결제 처리: 고객 ID " + customerId + ", 금액 " + amount + "원");
        
        /* 설명. 실제로는 결제 게이트웨이(PG사) 연동이 필요하지만 성공했다고 가정 */
        
        return true;
    }
    
    public boolean refundPayment(String orderId, double amount) {
        System.out.println("환불 처리: 주문 ID " + orderId + ", 금액 " + amount + "원");
        return true;
    }
}

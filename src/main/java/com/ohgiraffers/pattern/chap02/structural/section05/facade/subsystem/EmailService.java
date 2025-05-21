package com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem;


/**
 * 설명. 이메일 알림 서브시스템
 */
public class EmailService {
    public void sendOrderConfirmation(String customerEmail, String orderId) {
        System.out.println("주문 확인 이메일 발송: " + customerEmail + ", 주문 ID " + orderId);
    }

    public void sendShippingNotification(String customerEmail, String trackingNumber) {
        System.out.println("배송 알림 이메일 발송: " + customerEmail + ", 추적 번호 " + trackingNumber);
    }

    public void sendOrderCancellationEmail(String customerEmail, String orderId) {
        System.out.println("주문 취소 이메일 발송: " + customerEmail + ", 주문 ID " + orderId);
    }
}

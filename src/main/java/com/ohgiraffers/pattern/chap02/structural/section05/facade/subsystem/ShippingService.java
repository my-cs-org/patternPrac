package com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem;

/**
 * 설명. 배송 처리 서브시스템
 */
public class ShippingService {
    public String createShippingOrder(String orderId, String address) {
        System.out.println("배송 주문 생성: 주문 ID " + orderId + ", 주소 " + address);

        String trackingNumber = "TN" + System.currentTimeMillis();
        System.out.println("배송 추적 번호: " + trackingNumber);

        return trackingNumber;
    }

    public boolean cancelShipping(String trackingNumber) {
        System.out.println("배송 취소: 추적 번호 " + trackingNumber);
        return true;
    }
}

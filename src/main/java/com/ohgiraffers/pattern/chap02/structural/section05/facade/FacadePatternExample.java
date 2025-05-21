package com.ohgiraffers.pattern.chap02.structural.section05.facade;

/**
 * 설명. 퍼사드 패턴 사용 예제
 *  - 복잡한 서브시스템에 대한 단순한 인터페이스 제공
 *  - 클라이언트와 서브시스템 간의 결합도를 낮춤
 *  
 * 설명. 퍼사드 패턴의 장점
 *  1. 복잡한 서브시스템들을 간단한 인터페이스로 사용 가능
 *  2. 클라이언트 코드가 서브시스템의 구현 세부사항으로부터 분리됨
 *  3. 서브시스템 변경 시 퍼사드만 수정하면 되므로 유지보수에 용이
 */
public class FacadePatternExample {
    public static void main(String[] args) {
        System.out.println("===== 퍼사드 패턴 예제 실행 =====");
        
        /* 설명. 퍼사드 객체 생성 */
        ShoppingFacade shoppingFacade = new ShoppingFacade();
        
        /* 설명. 고객 정보 */
        String customerId = "c123";
        String customerEmail = "customer@ohgiraffers.com";
        String shippingAddress = "서울시 서초구 사평대로";
        
        /* 설명. 상품 정보 */
        String productId = "p123";
        int quantity = 2;
        double price = 50000.0;
        
        /* 설명. 퍼사드를 통한 주문 처리 */
        /* 설명. (재고 확인, 결제, 배송, 이메일 발송 등의 복잡한 과정을 하나의 메소드로 처리) */
        boolean orderSucess = shoppingFacade.placeOrder(
                customerId, customerEmail, productId, quantity, price, shippingAddress
        );

        if (orderSucess) {
            System.out.println("고객이 주문 성공 이후 단순 변심으로 인한 주문 취소 진행");

            /* 설명. 주문 취소 정보 (실제로는 DB에서 조회) */
            String orderId = "ORD" + System.currentTimeMillis();
            String trackingNumber = "TN" + System.currentTimeMillis();

            /* 설명. 퍼사드를 통한 주문 취소 처리 */
            /* 설명. (배송 취소, 환불, 재고 복구, 이메일 발송 등의 복잡한 과정을 하나의 메소드로 처리) */
            shoppingFacade.cancelOrder(
                    orderId, customerId, customerEmail, productId, quantity, price, trackingNumber
            );
        }
    }
}

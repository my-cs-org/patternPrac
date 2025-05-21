package com.ohgiraffers.pattern.chap02.structural.section05.facade;

import com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem.EmailService;
import com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem.InventoryService;
import com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem.PaymentService;
import com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem.ShippingService;

/**
 * 설명. 온라인 쇼핑 시스템의 퍼사드 클래스
 *  - 복잡한 서브시스템들의 기능을 단순화된 인터페이스로 제공
 */
public class ShoppingFacade {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShippingService shippingService;
    private EmailService emailService;

    public ShoppingFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this.emailService = new EmailService();
    }

    /**
     * 설명. 주문 처리를 위한 간단한 인터페이스 제공
     *  - 여러 서브시스템의 복잡한 상호작용을 숨김
     *
     * @param customerId
     * @param customerEmail
     * @param productId
     * @param quantity
     * @param price
     * @param shippingAddress
     * @return
     */
    public boolean placeOrder(String customerId, String customerEmail, String productId,
                              int quantity, double price, String shippingAddress) {
        System.out.println(" ===== 주문 처리 시작 =====");

        /* 설명. 1. 재고 확인 */
        if (!inventoryService.checkStock(productId, quantity)) {
            System.out.println("주문 실패: 재고 부족");
            return false;
        }

        /* 설명. 2. 결제 처리 */
        double totalAmount = price * quantity;
        if (!paymentService.processPayment(customerId, totalAmount)) {
            System.out.println("주문 실패: 결제 오류");
            return false;
        }

        /* 설명. 3. 재고 업데이트 */
        inventoryService.updateStock(productId, quantity);

        /* 설명. 4. 주문 ID 생성(실제로는 DB에서 생성) */
        String orderId = "ORD" + System.currentTimeMillis();
        
        /* 설명. 5. 배송 주문 생성 */
        String trackingNumber = shippingService.createShippingOrder(orderId, shippingAddress);
        
        /* 설명. 6. 주문 이메일 알림 발송 */
        emailService.sendOrderConfirmation(customerEmail, orderId);
        emailService.sendShippingNotification(customerEmail, trackingNumber);

        System.out.println("주문 처리 완료: 주문 ID " + orderId);
        return true;
    }

    /**
     * 설명. 주문 취소를 위한 간단한 인터페이스 제공
     *
     * @param orderId
     * @param customerId
     * @param customerEmail
     * @param productId
     * @param quantity
     * @param price
     * @param trackingNumber
     * @return
     */
    public boolean cancelOrder(String orderId, String customerId, String customerEmail,
                               String productId, int quantity, double price, String trackingNumber) {
        System.out.println("===== 주문 취소 처리 시작 =====");

        /* 설명. 1. 배송 취소 */
        if (!shippingService.cancelShipping(trackingNumber)) {
            System.out.println("취소 실패: 배송 취소 오류");
            return false;
        }

        /* 설명. 2. 결제 환불 */
        double totalAmount = price * quantity;
        if (!paymentService.refundPayment(orderId, totalAmount)) {
            System.out.println("취소 실패: 환불 처리 오류");
            return false;
        }

        /* 설명. 3. 재고 복구 */
        inventoryService.updateStock(productId, -quantity);     // 음수로 전달되는 값은 재고 증가를 의미

        /* 설명. 4. 취소 이메일 알림 발송 */
        emailService.sendOrderCancellationEmail(customerEmail, orderId);

        System.out.println("주문 취소 처리 완료: 주문 ID " + orderId);
        return true;
    }
}

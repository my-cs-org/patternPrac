package com.ohgiraffers.pattern.chap02.structural.section05.facade.subsystem;

/** 
 * 설명. 재고 관리 서브 시스템
 */
public class InventoryService {
    public boolean checkStock(String productId, int quantity) {
        System.out.println("재고 확인: 상품 ID " + productId + ", 수량 " + quantity);

        /* 설명. 실제로는 데이터베이스 조회가 필요하지만 예제에서는 항상 재고가 있다고 가정 */

        return true;
    }

    public void updateStock(String productId, int quantity) {
        System.out.println("재고 업데이트: 상품 ID " + productId + ", 감소 수량 " + quantity);
    }
}

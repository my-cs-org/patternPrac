package com.ohgiraffers.pattern.chap03.behavioral.section09.strategy;

/** 
 * 설명. 전략 패턴의 컨텍스트(Context) 클래스
 *  - 전략 객체를 사용하는 클래스
 */
public class SortContext {
    private SortingStrategy strategy;

    public SortContext() {
        
        /* 설명. 기본 전략 설정 가능(선택사항) */
    }
    
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
        System.out.println(strategy.getName() + " 전략으로 설정 됨");
    }
    
    public void executeSort(int[] array) {
        if (strategy == null) {
            System.out.println("정렬 전략이 설정되지 않음");
            return;
        }

        System.out.println("===== " + strategy.getName() + " 실행 =====");
        strategy.sort(array);
    }
}

package com.ohgiraffers.pattern.chap03.behavioral.section09.strategy;

import java.util.Arrays;
import java.util.Random;

/**
 * 설명. 전략 패턴 사용 예제
 *  - 알고리즘을 캡슐화하여 런타임에 교체 가능하게 함
 *  - 알고리즘의 변형을 클라이언트 코드와 분리
 *
 * 설명. 전략 패턴의 장점
 *  1. 알고리즘 교체가 용이함: 런타임에 알고리즘을 변경 가능
 *  2. 알고리즘 캡슐화: 구현 세부사항을 클라이언트로부터 숨김
 *  3. 조건문 제거: 복잡한 조건문을 대체하여 코드 가독성 향상
 *  4. 코드 재사용: 다양한 컨텍스트에서 동일한 전략 재사용 가능
 *
 * 설명. 전략 패턴의 단점
 *  1. 클래스 수 증가: 각 전략마다 별도의 클래스 필요
 *  2. 클라이언트가 전략을 알아야 함: 적절한 전략을 선택하기 위해 차이점을 알아야 함
 *  3. 간단한 알고리즘에 적용 시 오버엔지니어링 가능성
 *  4. 전략 객체 생성 및 전달에 따른 오버헤드 발생 가능
 *
 * 설명. 적절한 사용처
 *  1. 다양한 알고리즘 변형이 필요한 경우(정렬, 검색, 압축 등)
 *  2. 런타임에 알고리즘을 선택하거나 교체해야 하는 경우
 *  3. 알고리즘 구현 세부사항을 클라이언트로부터 숨기고 싶을 때
 *  4. 조건문을 대체하여 코드 유지보수성을 높이고 싶을 때
 */
public class StrategyPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 전략 패턴 예제 실행 =====");
        
        /* 설명. 컨텍스트 객체 생성 */
        SortContext context = new SortContext();

        /* 설명. 정렬할 랜덤 배열 생성 */
        int[] randomArray = generateRandomArray(10);
        System.out.println("원본 배열: " + Arrays.toString(randomArray));

        /* 설명. 버블 정렬 전략 사용 */
        int[] bubbleArray = Arrays.copyOf(randomArray, randomArray.length);
        context.setStrategy(new BubbleSortStrategy());
        context.executeSort(bubbleArray);

        /* 설명. 퀵 정렬 전략 사용 */
        int[] quickArray = Arrays.copyOf(randomArray, randomArray.length);
        context.setStrategy(new QuickSortStrategy());
        context.executeSort(quickArray);

        /* 설명. 병합 정렬 전략 사용 */
        int[] mergeArray = Arrays.copyOf(randomArray, randomArray.length);
        context.setStrategy(new MergeSortStrategy());
        context.executeSort(mergeArray);

        /* 설명. 큰 배열에서의 성능 비교 */
        System.out.println("\n=== 큰 배열에서의 성능 비교 ===");
        int[] largeArray = generateRandomArray(10000);

        /* 설명. 퀵 정렬 (큰 배열) */
        int[] largeQuickArray = Arrays.copyOf(largeArray, largeArray.length);
        context.setStrategy(new QuickSortStrategy());
        context.executeSort(largeQuickArray);

        /* 설명. 병합 정렬 (큰 배열) */
        int[] largeMergeArray = Arrays.copyOf(largeArray, largeArray.length);
        context.setStrategy(new MergeSortStrategy());
        context.executeSort(largeMergeArray);

        /* 설명. 버블 정렬은 큰 배열에서 매우 느리므로 작은 부분 배열만 테스트 */
        int[] smallBubbleArray = Arrays.copyOf(largeArray, 1000);
        context.setStrategy(new BubbleSortStrategy());
        context.executeSort(smallBubbleArray);
    }

    /* 설명. 지정된 크기의 랜덤 정수 배열 생성 */
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // 0-999 사이의 랜덤 정수
        }

        return array;
    }
}

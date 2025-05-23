package com.ohgiraffers.pattern.chap03.behavioral.section09.strategy;

import java.util.Arrays;
import java.util.Random;

/**
 * 설명. 전략 패턴 사용 예제
 *  - 알고리즘을 캡슐화하여 런타임에 교체 가능하게 함
 *  - 알고리즘의 변형을 클라이언트 코드와 분리
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

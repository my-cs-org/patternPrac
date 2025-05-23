package com.ohgiraffers.pattern.chap03.behavioral.section09.strategy;

import java.util.Arrays;

/**
 * 설명. 전략 패턴의 구체적인 전략(Concrete Strategy) 클래스
 *  - 버블 정렬 알고리즘 구현
 */
public class BubbleSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("버블 정렬 수행 중...");
        int n = array.length;

        /* 설명. 성능 측정을 위한 시작 시간 기록 */
        long startTime = System.nanoTime();

        /* 설명. 버블 정렬 알고리즘 구현 */
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {

                    /* 설명. 스위칭 */
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        /* 설명. 성능 측정을 위한 종료 시간 기록 */
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // 밀리초 단위로 변환

        System.out.println("버블 정렬 완료: " + Arrays.toString(array));
        System.out.println("소요 시간: " + duration + "ms");
    }

    @Override
    public String getName() {
        return "버블 정렬";
    }
}

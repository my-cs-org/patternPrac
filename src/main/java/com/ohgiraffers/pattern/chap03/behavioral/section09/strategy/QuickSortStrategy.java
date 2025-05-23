package com.ohgiraffers.pattern.chap03.behavioral.section09.strategy;

import java.util.Arrays;

/**
 * 설명. 전략 패턴의 구체적인 전략(Concrete Strategy) 클래스
 *  - 퀵 정렬 알고리즘 구현
 */
public class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("퀵 정렬 수행 중...");

        /* 설명. 성능 측정을 위한 시작 시간 기록 */
        long startTime = System.nanoTime();

        /* 설명. 퀵 정렬 알고리즘 호출 */
        quickSort(array, 0, array.length - 1);

        /* 설명. 성능 측정을 위한 종료 시간 기록 */
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;    // 밀리초 단위로 변환

        System.out.println("퀵 정렬 완료: " + Arrays.toString(array));
        System.out.println("소요 시간: " + duration + "ms");
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {

            /* 설명. 분할 위치 찾기 */
            int pivotIndex = partition(array, low, high);

            /* 설명. 분할된 두 부분을 재귀적으로 정렬 */
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {

        /* 설명. 피벗을 배열의 마지막 요소로 선택 */
        int pivot = array[high];
        int i = low - 1;        // 피벗보다 작은 요소들의 위치를 추적

        for (int j = low; j < high; j++) {

            /* 설명. 현재 요소가 피벗보다 작거나 같으면 i를 증가시키고 교환 */
            if (array[j] <= pivot) {
                i++;

                /* 설명. 스위칭 */
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        /* 설명. 피벗을 올바른 위치로 이동 */
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;   // 피벗의 위치 반환
    }

    @Override
    public String getName() {
        return "퀵 정렬";
    }
}

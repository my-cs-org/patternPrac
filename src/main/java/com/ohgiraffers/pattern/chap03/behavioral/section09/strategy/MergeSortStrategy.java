package com.ohgiraffers.pattern.chap03.behavioral.section09.strategy;

import java.util.Arrays;

/**
 * 설명. 전략 패턴의 구체적인 전략(Concrete Strategy) 클래스
 *  - 병합 정렬 알고리즘 구현
 */
public class MergeSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("병합 정렬 수행 중...");

        /* 설명. 성능 측정을 위한 시작 시간 기록 */
        long startTime = System.nanoTime();

        /* 설명. 병합 정렬 알고리즘 호출 */
        int[] tempArray = new int[array.length];
        mergeSort(array, tempArray, 0, array.length - 1);

        /* 설명. 성능 측정을 위한 종료 시간 기록 */
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;    // 밀리초 단위로 변환

        System.out.println("병합 정렬 완료: " + Arrays.toString(array));
        System.out.println("소요 시간: " + duration + "ms");
    }

    private void mergeSort(int[] array, int[] tempArray, int left, int right) {
        if (left < right) {

            /* 설명. 중간 지점 찾기 */
            int middle = left + (right - left) / 2;

            /* 설명. 왼쪽 부분 배열 정렬 */
            mergeSort(array, tempArray, left, middle);

            /* 설명. 오른쪽 부분 배열 정렬 */
            mergeSort(array, tempArray, middle + 1, right);

            /* 설명. 정렬된 두 부분 배열 병합 */
            merge(array, tempArray, left, middle, right);
        }
    }

    private void merge(int[] array, int[] tempArray, int left, int middle, int right) {
        // 두 부분 배열의 시작 인덱스
        int leftStart = left;
        int rightStart = middle + 1;

        // 임시 배열의 인덱스
        int tempIndex = left;

        // 두 부분 배열을 비교하여 임시 배열에 정렬된 순서로 병합
        while (leftStart <= middle && rightStart <= right) {
            if (array[leftStart] <= array[rightStart]) {
                tempArray[tempIndex] = array[leftStart];
                leftStart++;
            } else {
                tempArray[tempIndex] = array[rightStart];
                rightStart++;
            }
            tempIndex++;
        }

        // 왼쪽 부분 배열에 남은 요소가 있으면 임시 배열에 복사
        while (leftStart <= middle) {
            tempArray[tempIndex] = array[leftStart];
            leftStart++;
            tempIndex++;
        }

        // 오른쪽 부분 배열에 남은 요소가 있으면 임시 배열에 복사
        while (rightStart <= right) {
            tempArray[tempIndex] = array[rightStart];
            rightStart++;
            tempIndex++;
        }

        // 임시 배열의 내용을 원래 배열로 복사
        for (int i = left; i <= right; i++) {
            array[i] = tempArray[i];
        }
    }

    @Override
    public String getName() {
        return "병합 정렬";
    }
}

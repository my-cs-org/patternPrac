package com.ohgiraffers.pattern.chap02.structural.section06.flyweight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 설명. 플라이웨이트 패턴 사용 예제
 *  - 공통 상태를 공유하여 메모리 사용량을 줄일 수 있음
 *  - 많은 수의 유사한 객체를 효율적으로 관리
 */
public class FlyweightPatternExample {
    private static final int TREE_COUNT = 20;
    private static final int FOREST_SIZE = 500;
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("===== 플라이웨이트 패턴 예제 실행 =====");

        /* 설명. 나무 숲 생성 */
        List<Tree> forest = new ArrayList<>();

        /* 설명. 소나무 생성 (초록색) */
        System.out.println("===== 소나무 생성 =====");
        for (int i = 0; i < TREE_COUNT / 2; i++) {
            forest.add(plantTree("소나무", getRandomX(), getRandomY(), Color.GREEN, "거친 나무껍질"));
        }

        /* 설명. 벚나무 생성 (분홍색) */
        System.out.println("===== 벚나무 생성 =====");
        for (int i = 0; i < TREE_COUNT / 2; i++) {
            forest.add(plantTree("벚나무", getRandomX(), getRandomY(), Color.PINK, "매끄러운 나무껍질"));
        }

        /* 설명. 나무 숲 렌더링 */
        System.out.println("===== 나무 숲 렌더링 =====");
        for (Tree tree: forest) {
            tree.render();
        }

        /* 설명. 메모리 사용량 확인 */
        System.out.println("===== 메모리 사용 통계 =====");
        System.out.println("생성된 나무 개수: " + forest.size());
        System.out.println("생성된 나무 종류 개수: " + TreeFactory.getTreeTypeCount());
        System.out.println("메모리 절약: 객체 " + (forest.size() - TreeFactory.getTreeTypeCount()));
    }

    private static Tree plantTree(String name, int x, int y, Color color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        return new Tree(x, y, type);
    }

    private static int getRandomX() {
        return random.nextInt(FOREST_SIZE);
    }

    private static int getRandomY() {
        return random.nextInt(FOREST_SIZE);
    }
}

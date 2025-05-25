package com.ohgiraffers.pattern.chap02.structural.section06.flyweight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 설명. 플라이웨이트 패턴 사용 예제
 *  - 공통 상태를 공유하여 메모리 사용량을 줄일 수 있음
 *  - 많은 수의 유사한 객체를 효율적으로 관리
 *  
 * 설명. 플라이웨이트 패턴의 장점
 *  1. 메모리 사용량 감소
 *  2. 객체 생성 비용 절감
 *  3. 공유 객체를 통한 성능 향상
 *  4. 다수의 가상 객체를 효율적으로 처리 가능
 *  
 * 설명. 플라이웨이트 패턴의 단점
 *  1. 코드 복잡도 증가
 *  2. 공유 상태와 외부 상태를 분리하는 과정이 어려울 수 있음
 *  3. 객체의 상태 변경 시 모든 공유 객체에 영향을 줄 수 있음
 *  
 * 설명. 적절한 사용처
 *  1. 애플리케이션에서 많은 수의 유사한 객체를 사용할 때
 *  2. 객체의 대부분 상태를 공유 상태로 분리할 수 있을 때
 *  3. 메모리 사용량이 중요한 상황(예: 모바일 앱, 게임 등)
 *  4. 텍스트 에디터, 그래픽 처리, 게임 개발 등에서 활용
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

package com.ohgiraffers.pattern.chap02.structural.section06.flyweight;

/**
 * 설명. 플라이웨이트 패턴의 컨텍스트(Context) 클래스
 *  - 각 나무의 위치(x, y)처럼 객체마다 다른 데이터를 저장
 *  - 공통 데이터는 TreeType 객체를 참조하여 메모리 절약
 */
public class Tree {
    private int x;          // 개별 속성1
    private int y;          // 개별 속성2
    private TreeType type;  // 공통(공유) 속성

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void render() {
        type.render(x, y);
    }
}

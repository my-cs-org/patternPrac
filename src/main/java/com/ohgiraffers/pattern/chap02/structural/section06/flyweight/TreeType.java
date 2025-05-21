package com.ohgiraffers.pattern.chap02.structural.section06.flyweight;

import java.awt.*;

/**
 * 설명. 플라이웨이트 패턴의 공유 객체(Flyweight) 클래스
 *  - 여러 나무가 공통으로 사용하는 속성(이름, 색상, 질감)을 저장
 *  - 메모리 절약을 위해 동일한 속성을 가진 나무들이 이 객체를 공유함
 */
public class TreeType {
    private final String name;
    private final Color color;
    private final String texture;

    public TreeType(String name, Color color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
        System.out.println("TreeType 생성: " + name);
    }

    /* 설명. 특정 위치(x, y)에 나무 그리기 */
    public void render(int x, int y) {
        System.out.println(name + " 나무 그리기 [x=" + x + ", y=" + y +
                ", 색상=" + colorToString(color) + ", 텍스처=" + texture + "]");
    }

    /* 설명. Color 객체를 한글 설명으로 변환 */
    private String colorToString(Color color) {
        if (color == Color.GREEN) return "초록색";
        if (color == Color.RED) return "빨간색";
        if (color == Color.YELLOW) return "노란색";
        return "기타 색상";
    }

    public String getName() {
        return name;
    }
}

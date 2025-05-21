package com.ohgiraffers.pattern.chap02.structural.section06.flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 설명. 플라이웨이트 패턴의 팩토리(Factory) 클래스
 *  - 공유 객체를 생성하고 관리
 */
public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, Color color, String texture) {

        /* 설명. 키 생성 */
        String key = name + color.toString() + texture;
        
        /* 설명. 캐시된 TreeType 객체가 있는지 확인 */
        TreeType treeType = treeTypes.get(key);

        /* 설명. 없으면 새로 생성하고 캐시에 저장 */
        if (treeType == null) {
            treeType = new TreeType(name, color, texture);
            treeTypes.put(key, treeType);
            System.out.println("새로운 나무 종류 생성 및 캐싱: " + name);
        } else {
            System.out.println("캐시에서 나무 종류 재사용: " + name);
        }

        return treeType;
    }

    public static int getTreeTypeCount() {
        return treeTypes.size();
    }
}

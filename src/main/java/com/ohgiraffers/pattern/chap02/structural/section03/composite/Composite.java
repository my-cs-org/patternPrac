package com.ohgiraffers.pattern.chap02.structural.section03.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 설명. 컴포넌트 패턴의 복합체(Composite) 클래스
 *  - 자식 컴포넌트들을 가지는 복합 객체
 */
public class Composite implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Composite " + name + " 동작 수행");

        /* 설명. 자식 컴포넌트들에 대해 재귀적으로 동작 수행 */
        for (Component component : children) {
            component.operation();
        }
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Component> getChildren() {
        return children;
    }
}

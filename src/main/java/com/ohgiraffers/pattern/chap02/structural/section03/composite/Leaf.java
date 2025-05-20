package com.ohgiraffers.pattern.chap02.structural.section03.composite;

/**
 * 설명. 컴포지트 패턴의 리프(Leaf) 클래스
 *  - 단일 객체, 자식을 가지지 않음
 */
public class Leaf implements Component{
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + "동작 수행");
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("리프 노드는 자식을 추가할 수 없습니다.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("리프 노드는 자식을 추가할 수 없습니다.");
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("리프 노드는 자식을 추가할 수 없습니다.");
    }

    @Override
    public String getName() {
        return name;
    }
}

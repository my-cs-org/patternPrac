package com.ohgiraffers.pattern.chap01.creational.section05.prototype;

/**
 * 설명. 프로토타입 패턴의 추상 클래스
 *  - 복제 가능한 객체의 인터페이스 정의
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;
    
    /* 설명. 추상 메소드 - 각 도형이 자신을 그리는 방법 정의 */
    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    protected Object clone() {
        Object clone = null;
        
        /* 설명. clone 메소드를 사용하는 곳에서 예외처리를 안해도 되도록 예외 처리 */
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        return clone;
    }
}

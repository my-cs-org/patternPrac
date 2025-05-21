package com.ohgiraffers.pattern.chap02.structural.section07.proxy;

/**
 * 설명. 프록시 패턴의 프록시(Proxy) 클래스
 *  - 실제 객체에 대한 접근을 제어하는 대리자 역할
 */
public class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {

        /* 설명. 실제 이미지 객체가 필요할 때만 생성 (지연 로딩) */
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }

    @Override
    public String getFilename() {
        return filename;
    }
}

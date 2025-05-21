package com.ohgiraffers.pattern.chap02.structural.section07.proxy;

/**
 * 설명. 프록시 패턴의 실제 주체(Real Subject) 클래스
 *  - 실제 작업을 수행하는 객체
 */
public class RealImage implements Image{

    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("디스크에서 이미지 로딩: " + filename);
        
        /* 설명. 실제로는 여기서 파일을 로드하는 무거운 작업이 수행됨 */
        try {
            Thread.sleep(1000);         // 가상의 로딩 시간 부여
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void display() {
        System.out.println("이미지 표시: " + filename);
    }

    @Override
    public String getFilename() {
        return filename;
    }
}

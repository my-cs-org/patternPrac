package com.ohgiraffers.pattern.chap02.structural.section01.adapter;


public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("VLC 플레이어로 재생 중: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        
        /* 설명. VLC 플레이어는 MP4 파일을 재생하지 않고 아무것도 하지 않음 */
    }
}

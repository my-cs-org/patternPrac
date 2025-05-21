package com.ohgiraffers.pattern.chap02.structural.section01.adapter;

/**
 * 설명. 미디어 어댑터 클래스
 *  - MediaPlayer 인터페이스와 AdvancedMediaPlayer 인터페이스 간의 브릿지 역할
 */
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    /* 설명. 생성자가 어떤 고급 플레이어를 사용할지 결정 */
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {

        /* 설명. 오디오 타입에 따라 적절한 고급 플레이어의 메소드 호출 */
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

package com.ohgiraffers.pattern.chap02.structural.section01.adapter;

/**
 * 클라이언트가 직접 사용하는 AudioPlayer 클래스
 *  - MP3는 직접 재생하고, VLC와 MP4는 어댑터를 통해 재생
 */
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        
        /* 설명. MP3 파일을 재생하는 내장 기능 */
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("오디오 플레이어로 MP3 재생 중: " + fileName);
        }

        /* 설명. VLC나 MP4 파일은 어댑터를 통해 재생 */
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        
        /* 설명. 지원하지 않는 형식 */
        else {
            System.out.println("지원하지 않는 미디어 형식입니다: " + audioType);
        }
    }
}

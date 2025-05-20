package com.ohgiraffers.pattern.chap02.structural.section01.adapter;

/**
 * 설명. 어댑터 패턴 사용 예제
 *  - 서로 다른 인터페이스를 가진 클래스들이 함께 작동할 수 있도록 함
 *  - 기존 코드를 변경하지 않고 새로운 기능을 통합
 */
public class AdapterPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 어댑터 패턴 예제 실행 =====");

        /* 설명. AudioPlayer 객체 생성 */
        AudioPlayer audioPlayer = new AudioPlayer();

        /* 설명. 다양한 형식의 오디오 파일 재생 */
        System.out.println("===== 다양한 형식의 미디어 재생 테스트 =====");
        
        /* 설명. 기존 지원 방식 (MP3) */
        audioPlayer.play("mp3", "상어가족_Baby_Shark_Official_Audio.mp3");

        /* 설명. 어댑터를 통한 확장 지원 형식 (VLC) */
        audioPlayer.play("vlc", "인기동요_모음_2025_재생목록.vlc");
        
        /* 설명. 어댑터를 통한 확장 지원 형식 (MP4) */
        audioPlayer.play("mp4", "펭수와_함께_부르는_뽀로로_테마송_HD.mp4");
        
        /* 설명. 지원하지 않는 형식 */
        audioPlayer.play("avi", "윤도현_뽀로로_메탈.avi");
    }
}

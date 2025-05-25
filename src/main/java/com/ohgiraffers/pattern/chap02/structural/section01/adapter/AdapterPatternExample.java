package com.ohgiraffers.pattern.chap02.structural.section01.adapter;

/**
 * 설명. 어댑터 패턴 사용 예제
 *  - 서로 다른 인터페이스를 가진 클래스들이 함께 작동할 수 있도록 함
 *  - 기존 코드를 변경하지 않고 새로운 기능을 통합
 *  
 * 설명. 어댑터 패턴의 장점
 *  1. 기존 코드를 변경하지 않고 새로운 인터페이스와 함께 작동 가능
 *  2. 코드의 재사용성 증가
 *  3. 클래스 간의 결합도를 낮춤
 *  4. 레거시 코드와 새 코드의 통합이 용이함
 *  
 * 설명. 어댑터 패턴의 단점
 *  1. 어댑터 클래스가 추가되어 복잡도가 증가할 수 있음
 *  2. 때로는 직접 인터페이스를 수정하는 것이 더 간단할 수 있음
 *  3. 어댑터를 통한 간접 호출로 약간의 성능 오버헤드 발생 가능
 *  
 * 설명. 적절한 사용처
 *  1. 기존 클래스를 사용하고 싶지만 인터페이스가 맞지 않을 때
 *  2. 이미 만들어진 클래스를 새로운 인터페이스에 맞게 재사용하고 싶을 때
 *  3. 여러 하위 클래스가 있는데, 각 하위 클래스마다 메소드를 추가하는 것이 비효율적일 때
 *  4. 써드파티 라이브러리를 사용하면서 기존 코드와 통합해야 할 때
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

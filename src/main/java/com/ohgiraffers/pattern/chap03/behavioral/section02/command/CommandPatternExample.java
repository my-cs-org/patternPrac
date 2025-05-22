package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 커맨드 패턴 사용 예제
 *  - 요청을 객체로 캡슐화하여 매개변수화, 큐에 저장, 로깅, 취소 가능하게 함
 *  - 명령을 실행하는 객체와 명령을 발행하는 객체를 분리
 *  - 명령을 발행하는 객체 (Invoker): RemoteControl
 *  - 명령을 실행하는 객체 (Receiver): Light, Stereo
 *  - 명령 객체 (Command): LightOnCommand, LightOffCommand, StereoOnWithCDCommand, StereoOffCommand
 */
public class CommandPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 커맨드 패턴 예제 실행 =====");
        
        /* 설명. 리모컨 생성 (호출자) */
        RemoteControl remoteControl = new RemoteControl();
        
        /* 설명. 장치 생성 (수신자) */
        Light livingRoomLight = new Light("거실");
        Light kitchenLight = new Light("주방");
        Stereo stereo = new Stereo("거실");

        /* 설명. 명령 객체 생성 */
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        /* 설명. 리모컨에 명령 설정 */
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOnWithCD, stereoOff);

        /* 설명. 리모컨 상태 출력 */
        System.out.println(remoteControl);

        /* 설명. 리모컨 버튼 누르기 */
        System.out.println("\n=== 리모컨 버튼 테스트 ===");
        remoteControl.onButtonWasPushed(0);   // 거실 조명 켜기
        remoteControl.offButtonWasPushed(0);  // 거실 조명 끄기
        remoteControl.onButtonWasPushed(1);   // 주방 조명 켜기
        remoteControl.offButtonWasPushed(1);  // 주방 조명 끄기

        // 실행 취소 테스트
        System.out.println("\n=== 실행 취소 테스트 ===");
        remoteControl.onButtonWasPushed(2);   // 스테레오 켜기
        remoteControl.undoButtonWasPushed();      // 스테레오 끄기 (실행 취소)

        remoteControl.offButtonWasPushed(2);  // 스테레오 끄기
        remoteControl.undoButtonWasPushed();      // 스테레오 켜기 (실행 취소)
    }
}

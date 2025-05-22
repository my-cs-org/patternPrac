package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 구체적인 명령(Concrete Command) 클래스
 *  - 스테레오 켜기 및 CD 설정 명령
 */
public class StereoOnWithCDCommand implements Command {
    private Stereo stereo;
    private int previousVolume;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        previousVolume = stereo.getVolume();
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);  // 볼륨을 11로 설정
    }

    @Override
    public void undo() {
        stereo.off();
        stereo.setVolume(previousVolume);
    }
}

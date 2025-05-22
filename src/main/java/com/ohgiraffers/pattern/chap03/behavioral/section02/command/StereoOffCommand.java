package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 구체적인 명령(Concrete Command) 클래스
 *  - 스테레오 끄기 명령
 */
public class StereoOffCommand implements Command {
    private Stereo stereo;
    private int preveiousVolume;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        preveiousVolume = stereo.getVolume();
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setVolume(preveiousVolume);
    }
}

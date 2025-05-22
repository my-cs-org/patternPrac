package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 구체적인 명령(Concrete Command) 클래스
 *  - 조명 끄기 명령
 */
public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

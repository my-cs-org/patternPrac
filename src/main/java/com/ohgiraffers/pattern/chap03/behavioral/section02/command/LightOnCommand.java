package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 구체적인 명령(Concrete Command) 클래스
 *  - 조명 켜기 명령
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

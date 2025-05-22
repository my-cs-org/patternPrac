package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 널 객체(Null Object) 패턴이 적용된 명령 클래스
 *  - 아무 동작도 하지 않는 명령
 *  - 널 객체 패턴: null 참조를 대체하는 패턴
 */
public class NoCommand implements Command {
    @Override
    public void undo() {

        /* 설명. 아무 동작 없음 */
    }

    @Override
    public void execute() {

        /* 설명. 아무 동작 없음 */
    }
}

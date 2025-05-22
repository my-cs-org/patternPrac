package com.ohgiraffers.pattern.chap03.behavioral.section02.command;

/**
 * 설명. 커맨드 패턴의 명령(Command) 인터페이스
 *  - 모든 명령 객체가 구현해야 하는 인터페이스
 */
public interface Command {
    void execute();
    void undo();
}

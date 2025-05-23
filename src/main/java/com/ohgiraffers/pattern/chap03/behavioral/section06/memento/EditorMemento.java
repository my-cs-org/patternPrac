package com.ohgiraffers.pattern.chap03.behavioral.section06.memento;

/**
 * 설명. 메멘토 패턴의 메멘토(Memento) 클래스
 *  - 원본 객체의 내부 상태를 저장
 */
public class EditorMemento {
    private final String content;
    private final int cursorPosition;
    private final String timestamp;

    public EditorMemento(String content, int cursorPosition, String timestamp) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.timestamp = timestamp;
    }

    /* 설명. 메멘토 객체는 상태를 외부에서 변경할 수 없도록 getter만 제공한다. */
    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public String getTimestamp() {
        return timestamp;
    }
}

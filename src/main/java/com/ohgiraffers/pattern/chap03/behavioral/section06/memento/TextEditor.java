package com.ohgiraffers.pattern.chap03.behavioral.section06.memento;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 설명. 메멘토 패턴의 원본(Originator) 클래스
 *  - 상태를 가지며 메멘토를 생성하고 복원하는 클래스
 */
public class TextEditor {
    private String content;
    private int cursorPosition;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
    }

    public void write(String text) {
        if (content.length() == 0) {
            content = text;
        } else {

            /* 설명. 커서 위치에 텍스트 삽입 */
            String before = content.substring(0, cursorPosition);
            String after = content.substring(cursorPosition);
            content = before + text + after;
        }
        cursorPosition += text.length();
        System.out.println("텍스트 입력: " + text);
        System.out.println("현재 내용: " + content);
    }

    public void setCursor(int position) {
        if (position >= 0 && position <= content.length()) {
            this.cursorPosition = position;
            System.out.println("커서 위치 변경: " + position);
        } else {
            System.out.println("유효하지 않은 커서 위치입니다.");
        }
    }

    public String getContent() {
        return content;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    /* 설명. 현재 상태를 저장하는 메멘토 생성 */
    public EditorMemento save() {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("에디터 상태 저장: " + timestamp);
        return new EditorMemento(content, cursorPosition, timestamp);
    }

    /* 설명. 메멘토로부터 상태 복원 */
    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        System.out.println("에디터 상태 복원: " + memento.getTimestamp());
        System.out.println("복원된 내용: " + content);
    }
}

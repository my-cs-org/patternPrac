package com.ohgiraffers.pattern.chap03.behavioral.section06.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 설명. 메멘토 패턴의 관리자(Caretaker) 클래스
 *  - 메멘토 객체를 저장하고 관리하는 클래스
 */
public class History {
    private List<EditorMemento> mementos = new ArrayList<>();
    private int currentIndex = -1;
    
    /* 설명. 메멘토 저장 */
    public void push(EditorMemento memento) {

        /* 설명. 현재 위치 이후의 기록은 삭제 (새로운 변경사항 이후의 실행취소 기록은 무효화) */
        if (currentIndex < mementos.size() - 1) {
            mementos = new ArrayList<>(mementos.subList(0, currentIndex + 1));
        }

        mementos.add(memento);
        currentIndex = mementos.size() - 1;
        System.out.println("히스토리에 상태 저장 (총 " + mementos.size() + "개의 저장점)");
    }

    /* 설명. 실행 취소 (undo) */
    public EditorMemento undo() {
        if (currentIndex <= 0) {
            System.out.println("더 이상 실행 취소할 수 없습니다.");
            return currentIndex == 0 ? mementos.get(0) : null;
        }

        currentIndex--;
        System.out.println("실행 취소 (이전 상태로 돌아가기)");
        return mementos.get(currentIndex);
    }

    /* 설명. 다시 실행 (redo) */
    public EditorMemento redo() {
        if (currentIndex >= mementos.size() - 1) {
            System.out.println("더 이상 다시 실행할 수 없습니다.");
            return currentIndex >= 0 ? mementos.get(currentIndex) : null;
        }

        currentIndex++;
        System.out.println("다시 실행 (다음 상태로 이동)");
        return mementos.get(currentIndex);
    }

    /* 설명. 저장된 메멘토 개수 반환 */
    public int size() {
        return mementos.size();
    }

    /* 설명. 현재 인덱스 반환 */
    public int getCurrentIndex() {
        return currentIndex;
    }
}

package com.ohgiraffers.pattern.chap03.behavioral.section06.memento;

/**
 * 설명. 메멘토 패턴 사용 예제
 *  - 객체의 상태를 저장하고 복원할 수 있게 함
 *  - 캡슐화를 위반하지 않으면서 객체 상태의 스냅샷을 생성
 */
public class MementoPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 메멘토 패턴 예제 실행 =====");

        /* 설명. 텍스트 에디터와 히스토리 객체 생성 */
        TextEditor editor = new TextEditor();
        History history = new History();

        /* 설명. 초기 상태 저장 */
        history.push(editor.save());
        
        /* 설명. 텍스트 입력 및 상태 저장 */
        System.out.println("===== 첫 번째 텍스트 입력 =====");
        editor.write("안녕하세요, ");
        history.push(editor.save());

        System.out.println("===== 두 번째 텍스트 입력 =====");
        editor.write("메멘토 패턴입니다.");
        history.push(editor.save());
        
        /* 설명. 커서 위치 변경 및 상태 저장 */
        System.out.println("===== 커서 위치 변경 =====");
        editor.setCursor(7);
        history.push(editor.save());
        
        /* 설명. 추가 텍스트 입력 및 상태 저장 */
        System.out.println("===== 세 번째 텍스트 입력 =====");
        editor.write("디자인 ");
        history.push(editor.save());

        /* 설명. 실행 취소 (undo) 테스트 */
        System.out.println("===== 실행 취소 (undo) 테스트 =====");
        editor.restore(history.undo()); // "디자인 " 입력 취소
        editor.restore(history.undo()); // 커서 위치 변경 취소

        /* 설명. 실행 (redo) 테스트 */
        System.out.println("===== 다시 실행 (redo) 테스트 =====");
        editor.restore(history.redo()); // 커서 위치 변경 복원
        editor.restore(history.redo()); // "디자인 " 입력 복원

        /* 설명. 새로운 변경 후 redo 불가능 테스트 */
        System.out.println("===== 새로운 변경 후 redo 불가능 테스트 =====");
        editor.write("새로운 ");
        history.push(editor.save());

        /* 설명. redo 시도 (이전 redo 기록은 무효화됨) */
        System.out.println("===== 무효화된 redo 시도 =====");
        EditorMemento memento = history.redo();
        if (memento != null) {
            editor.restore(memento);
        }
    }
}

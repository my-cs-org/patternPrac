package com.ohgiraffers.pattern.chap03.behavioral.section06.memento;

/**
 * 설명. 메멘토 패턴 사용 예제
 *  - 객체의 상태를 저장하고 복원할 수 있게 함
 *  - 캡슐화를 위반하지 않으면서 객체 상태의 스냅샷을 생성
 *
 * 설명. 메멘토 패턴의 장점
 *  1. 캡슐화를 유지하면서 객체 상태 저장 및 복원 가능
 *  2. 객체 상태 기록을 객체 외부에서 관리 가능
 *  3. 실행 취소(undo), 다시 실행(redo) 기능 구현에 적합
 *  4. 객체 상태의 스냅샷을 만들어 롤백 기능 제공
 *
 * 설명. 메멘토 패턴의 단점
 *  1. 상태를 저장하는 비용이 클 수 있음(메모리 사용량 증가)
 *  2. 상태 저장 빈도가 높을 경우 성능 저하 가능성
 *  3. 메멘토 객체 관리에 추가적인 코드 필요
 *  4. 자바에서는 가비지 컬렉션으로 인해 메멘토 객체 관리에 주의 필요
 *
 * 설명. 적절한 사용처
 *  1. 텍스트 에디터의 실행 취소/다시 실행 기능
 *  2. 게임의 세이브 포인트 기능
 *  3. 트랜잭션 처리 시스템의 롤백 기능
 *  4. 상태 복원이 필요한 시뮬레이션이나 마법사(wizard) 인터페이스
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

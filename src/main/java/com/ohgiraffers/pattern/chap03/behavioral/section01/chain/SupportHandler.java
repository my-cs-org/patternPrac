package com.ohgiraffers.pattern.chap03.behavioral.section01.chain;

/**
 * 설명. 책임 연쇄 패턴의 핸들러(Handler) 추상 클래스
 *  - 요청을 처리하거나 다음 핸들러로 전달하는 기본 구조 정의
 */
public abstract class SupportHandler {
    protected SupportHandler nextHandler;
    protected int level;

    public SupportHandler(int level) {
        this.level = level;
    }

    /* 설명. 다음 핸들러 설정 */
    public SupportHandler setNext(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;     // 체이닝을 위해 다음 핸들러 반환
    }
    
    /* 설명. 요청 처리 */
    public final void handleRequest(SupportRequest request) {
        if (canHandle(request)) {
            process(request);
        } else if (nextHandler != null) {
            System.out.println(getHandlerName() + "에서 처리할 수 없어 다음 단계로 전달합니다.");
        } else {
            System.out.println("모든 지원팀에서 처리할 수 없는 요청입니다: " + request.getDescription());
        }
    }

    /* 설명. 요청을 처리할 수 있는지 확인 */
    protected abstract boolean canHandle(SupportRequest request);

    /* 설명. 요청 처리 로직 */
    protected abstract void process(SupportRequest request);

    /* 설명. 핸들러 이름 반환 */
    protected abstract String getHandlerName();
}

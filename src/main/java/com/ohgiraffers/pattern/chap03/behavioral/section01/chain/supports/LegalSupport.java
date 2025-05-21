package com.ohgiraffers.pattern.chap03.behavioral.section01.chain.supports;


import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.SupportHandler;
import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.SupportRequest;

/**
 * 설명. 법적 문제 관련 문의를 처리하는 핸들러
 */
public class LegalSupport  extends SupportHandler {

    public LegalSupport() {
        super(SupportRequest.LEVEL_LEGAL);
    }

    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getLevel() == SupportRequest.LEVEL_LEGAL;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("법무팀에서 처리: " + request);
    }

    @Override
    protected String getHandlerName() {
        return "법무팀";
    }
}

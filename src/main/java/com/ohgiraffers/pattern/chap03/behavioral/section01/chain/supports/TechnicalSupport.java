package com.ohgiraffers.pattern.chap03.behavioral.section01.chain.supports;


import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.SupportHandler;
import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.SupportRequest;

/**
 * 설명. 기술적인 문의를 처리하는 핸들러
 */
public class TechnicalSupport  extends SupportHandler {

    public TechnicalSupport() {
        super(SupportRequest.LEVEL_TECHNICAL);
    }

    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getLevel() == SupportRequest.LEVEL_TECHNICAL;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("기술 지원팀에서 처리: " + request);
    }

    @Override
    protected String getHandlerName() {
        return "기술 지원팀";
    }
}

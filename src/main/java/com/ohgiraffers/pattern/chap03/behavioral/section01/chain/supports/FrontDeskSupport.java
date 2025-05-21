package com.ohgiraffers.pattern.chap03.behavioral.section01.chain.supports;

import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.SupportHandler;
import com.ohgiraffers.pattern.chap03.behavioral.section01.chain.SupportRequest;

/**
 * 설명. 기본적인 고객 문의를 처리하는 핸들러
 */
public class FrontDeskSupport extends SupportHandler {

    public FrontDeskSupport() {
        super(SupportRequest.LEVEL_BASIC);
    }

    @Override
    protected boolean canHandle(SupportRequest request) {
        return request.getLevel() == SupportRequest.LEVEL_BASIC;
    }

    @Override
    protected void process(SupportRequest request) {
        System.out.println("프론트 데스크에서 처리: " + request);
    }

    @Override
    protected String getHandlerName() {
        return "프론트 데스크";
    }
}

package com.ohgiraffers.pattern.chap03.behavioral.section01.chain;

/**
 * 설명. 책임 연쇄 패턴에서 처리할 요청 클래스
 */
public class SupportRequest {
    public static final int LEVEL_BASIC = 1;        // 기본 문의
    public static final int LEVEL_TECHNICAL = 2;    // 기술 문의
    public static final int LEVEL_BILLING = 3;      // 결제 문의
    public static final int LEVEL_LEGAL = 4;        // 법적 문의

    private int level;
    private String description;

    public SupportRequest(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String levelString;
        switch (level) {
            case LEVEL_BASIC: levelString = "기본 문의"; break;
            case LEVEL_TECHNICAL: levelString = "기술 문의"; break;
            case LEVEL_BILLING: levelString = "결제 문의"; break;
            case LEVEL_LEGAL: levelString = "법적 문의"; break;
            default: levelString = "알 수 없는 문의";
        }
        return levelString + " " + description;
    }
}

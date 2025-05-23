package com.ohgiraffers.pattern.chap03.behavioral.section10.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 템플릿 메소드 패턴의 구체적인 서브클래스
 * - 차 음료 구현
 */
public class Tea extends Beverage {
    
    @Override
    protected void brew() {
        System.out.println("차를 우려내는 중");
    }
    
    @Override
    protected boolean customerWantsCondiments() {
        String answer = getUserInput();
        
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void addCondiments() {
        System.out.println("레몬을 추가하는 중");
    }

    private String getUserInput() {
        String answer = null;
        
        System.out.print("차에 레몬을 추가할까요? (y/n) ");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println("입력 오류");
        }
        
        if (answer == null) {
            return "no";
        }
        
        return answer;
    }
    
    @Override
    protected void hook() {
        System.out.println("차가 준비되었습니다. Good Tea Time!~");
    }
} 
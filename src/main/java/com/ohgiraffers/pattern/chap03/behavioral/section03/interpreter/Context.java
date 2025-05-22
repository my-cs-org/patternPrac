package com.ohgiraffers.pattern.chap03.behavioral.section03.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명. 인터프리터 패턴의 컨텍스트(Context) 클래스
 *  - 변수와 값을 저장하는 맵을 포함
 */
public class Context {
    private Map<String, Integer> variables;

    public Context() {
        variables = new HashMap<>();
    }

    public void setVariable(String name, int value) {
        variables.put(name, value);
    }

    public int getVariable(String name) {
        
        /* 설명. 해당 키가 없으면 defaultValue인 0이 나옴 */
        return variables.getOrDefault(name, 0);
    }
}

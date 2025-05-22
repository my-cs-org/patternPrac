package com.ohgiraffers.pattern.chap03.behavioral.section03.interpreter;

/**
 * 설명. 인터프리터 패턴 사용 예제
 *  - 문법 규칙을 클래스화하여 언어를 해석
 *  - 간단한 언어의 인터프리터를 구현할 때 유용
 *  
 * 설명. 인터프리터 패턴의 장점
 *  1. 문법을 클래스로 표현하여 확장이 용이함
 *  2. 각 규칙을 쉽게 구현, 수정, 확장할 수 있음
 *  3. 새로운 표현식을 쉽게 추가할 수 있음
 *  
 * 설명. 주의점
 *  1. 복잡한 문법에서는 너무 많은 클래스가 필요할 수 있음
 *  2. 성능이 중요한 경우에는 파서 생성기 도구를 고려해야 함
 */
public class InterpreterPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 인터프리터 패턴 예제 실행 =====");

        /* 설명. 컨텍스트 생성 및 변수 설정 */
        Context context = new Context();
        context.setVariable("x", 10);
        context.setVariable("y", 5);
        context.setVariable("z", 2);

        /* 설명. 표현식 파서 생성 */
        Parser parser = new Parser();

        /* 설명. 후위 표기법으로 표현식 정의 및 해석 */
        System.out.println("===== 변수 값 =====");
        System.out.println("x = " + context.getVariable("x"));
        System.out.println("y = " + context.getVariable("y"));
        System.out.println("z = " + context.getVariable("z"));

        System.out.println("===== 표현식 평가 =====");
        
        /* 설명. 'x y +' => x + y */
        Expression expression1 = parser.parse("x y +");
        System.out.println("x + y = " + expression1.interpret(context));

        /* 설명. 'x y -' => x - y */
        Expression expression2 = parser.parse("x y -");
        System.out.println("x - y = " + expression2.interpret(context));

        /* 설명. 'x y * z +' => (x * y) + z */
        Expression expression3 = parser.parse("x y * z +");
        System.out.println("x * y + z = " + expression3.interpret(context));

        /* 설명. 'x y z - +' => x + (y - z) */
        Expression expression4 = parser.parse("x y z - +");
        System.out.println("x + (y - z) = " + expression4.interpret(context));

        /* 설명. 숫자 리터럴도 사용할 수 있음 */
        Expression expression5 = parser.parse("x 2 *");
        System.out.println("x * 2 = " + expression5.interpret(context));
    }
}

package com.ohgiraffers.pattern.chap02.structural.section03.composite;

/**
 * 설명. 컴포지트 패턴 사용 예제
 *  - 객체들을 트리 구조로 구성하여 부분-전체 계층을 표현
 *  - 개별 객체와 복합 객체를 동일하게 다룰 수 있음
 */
public class CompositePatternExample {
    public static void main(String[] args) {
        System.out.println("===== 컴포넌트 패턴 예제 실행 =====");
        
        /* 설명. 복합 객체(폴더의 개념) 생성 */
        Composite root = new Composite("루트");
        Composite branch1 = new Composite("브랜치1");
        Composite branch2 = new Composite("브랜치2");
        Composite branch1_1 = new Composite("브랜치1-1");

        /* 설명. 단일 객체(파일의 개념) 생성 */
        Component leaf1 = new Leaf("리프1");
        Component leaf2 = new Leaf("리프2");
        Component leaf3 = new Leaf("리프3");
        Component leaf4 = new Leaf("리프4");
        Component leaf5 = new Leaf("리프5");

        /**
         * 설명. 트리 구조 구성
         *  root
         *  ├── branch1
         *  │   ├── leaf2
         *  │   └── branch1_1
         *  │       └── leaf3
         *  ├── branch2
         *  │   ├── leaf4
         *  │   └── leaf5
         *  └── leaf1
         */
        root.add(branch1);
        root.add(branch2);
        root.add(leaf1);

        branch1.add(leaf2);
        branch1.add(branch1_1);

        branch1_1.add(leaf3);

        branch2.add(leaf4);
        branch2.add(leaf5);

        /* 설명. 전체 구조 출력 */
        System.out.println("===== 전체 트리 구조 동작 =====");
        root.operation();

        /* 설명. 특정 브랜치만 동작 */
        System.out.println("===== 브랜치1 동작 =====");
        branch1.operation();

        /* 설명. 브랜치1-1에서 컴포넌트 삭제 후 동작 */
        System.out.println("===== 리프3 삭제 후 브랜치1-1 동작 =====");
        branch1_1.remove(leaf3);
        branch1_1.operation();

        /* 설명. 브랜치2에서 컴포넌트 추가 후 동작 */
        System.out.println("===== 새 리프 추가 후 브랜치2 동작 =====");
        branch2.add(new Leaf("새 리프"));
        branch2.operation();
    }
}

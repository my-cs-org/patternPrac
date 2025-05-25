package com.ohgiraffers.pattern.chap03.behavioral.section04.iterator;

/**
 * 설명. 이터레이터 패턴 사용 예제
 *  - 컬렉션의 내부 구조를 노출하지 않고 요소에 순차적으로 접근
 *  - 서로 다른 자료구조를 동일한 방식으로 순회할 수 있게 함
 *
 * 설명. 이터레이터 패턴의 장점
 *  1. 컬렉션의 내부 구조(ArrayList, 배열)를 숨김
 *  2. 동일한 인터페이스로 서로 다른 컬렉션을 순회
 *  3. 단일 책임 원칙: 순회 로직이 컬렉션과 분리됨
 *  4. 새로운 컬렉션 유형 추가가 용이함
 *
 * 설명. 이터레이터 패턴의 단점
 *  1. 간단한 컬렉션에 적용하면 오버엔지니어링이 될 수 있음
 *  2. 추가적인 클래스와 인터페이스로 인한 복잡도 증가
 *  3. 직접 인덱스 접근보다 성능이 떨어질 수 있음
 *  4. 상태를 유지하는 이터레이터는 병렬 처리에 주의가 필요함
 *
 * 설명. 적절한 사용처
 *  1. 다양한 자료구조에 대한 일관된 순회 방법이 필요할 때
 *  2. 컬렉션의 내부 구현을 노출하지 않고 접근해야 할 때
 *  3. 여러 종류의 순회 알고리즘을 지원해야 할 때
 *  4. 복합 객체의 계층적 구조를 순회해야 할 때
 */
public class IteratorPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 이터레이터 패턴 예제 실행 =====");

        // 서로 다른 자료구조를 사용하는 책장 생성
        FictionBookShelf fictionBookShelf = new FictionBookShelf();
        NonFictionBookShelf nonFictionBookShelf = new NonFictionBookShelf();

        // 사서 생성 (클라이언트)
        Librarian librarian = new Librarian(fictionBookShelf, nonFictionBookShelf);

        // 모든 도서 출력
        System.out.println("===== 전체 도서 목록 =====");
        librarian.printBooks();

        // 특정 장르 도서만 출력
        System.out.println("===== 판타지 장르 도서 목록 =====");
        librarian.printBooksByGenre("판타지");

        // 고전 도서 출력 (특정 연도 이전 출간)
        System.out.println("===== 1980년 이전 출간된 고전 도서 =====");
        librarian.printClassicBooks(1980);

        // 직접 이터레이터 사용 예시
        System.out.println("===== 직접 이터레이터 사용 =====");
        Iterator<Book> fictionIterator = fictionBookShelf.createIterator();
        System.out.println("소설 책장의 첫 번째 도서: " + fictionIterator.next());
    }
}

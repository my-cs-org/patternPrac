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

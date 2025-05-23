package com.ohgiraffers.pattern.chap03.behavioral.section04.iterator;

/**
 * 설명. 이터레이터 패턴의 클라이언트 클래스
 *  - 서로 다른 컬렉션을 동일한 방식으로 순회
 */
public class Librarian {
    private Container<Book> fictionBookShelf;
    private Container<Book> nonFictionBookShelf;

    public Librarian(Container<Book> fictionBookShelf, Container<Book> nonFictionBookShelf) {
        this.fictionBookShelf = fictionBookShelf;
        this.nonFictionBookShelf = nonFictionBookShelf;
    }

    public void printBooks() {
        System.out.println("도서 목록");
        System.out.println("---------");
        System.out.println("소설 도서");
        printBooks(fictionBookShelf.createIterator());

        System.out.println("논픽션 도서");
        printBooks(nonFictionBookShelf.createIterator());
    }

    private void printBooks(Iterator<Book> iterator) {
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }

    public void printBooksByGenre(String genre) {
        System.out.println("장르: " + genre + " 도서 목록");
        System.out.println("---------");
        printBooksByGenre(fictionBookShelf.createIterator(), genre);
        printBooksByGenre(nonFictionBookShelf.createIterator(), genre);
    }

    private void printBooksByGenre(Iterator<Book> iterator, String genre) {
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(book);
            }
        }
    }

    public void printClassicBooks(int yearThreshold) {
        System.out.println(yearThreshold + "년 이전 출간된 고전 도서");
        System.out.println("---------");
        printClassicBooks(fictionBookShelf.createIterator(), yearThreshold);
        printClassicBooks(nonFictionBookShelf.createIterator(), yearThreshold);
    }

    private void printClassicBooks(Iterator<Book> iterator, int yearThreshold) {
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getPublishYear() < yearThreshold) {
                System.out.println(book);
            }
        }
    }
}

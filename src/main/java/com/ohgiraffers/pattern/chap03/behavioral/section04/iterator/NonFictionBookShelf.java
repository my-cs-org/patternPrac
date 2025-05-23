package com.ohgiraffers.pattern.chap03.behavioral.section04.iterator;

/**
 * 설명. 구체적인 컨테이너 클래스
 *  - 배열을 사용하여 논픽션 도서를 저장 (다른 자료구조 사용)
 */
public class NonFictionBookShelf implements Container<Book> {
    private static final int MAX_BOOKS = 6;
    private int numberOfBooks = 0;
    private Book[] books;

    public NonFictionBookShelf() {
        books = new Book[MAX_BOOKS];

        addBook("사피엔스", "유발 하라리", "역사", 2011);
        addBook("총, 균, 쇠", "재레드 다이아몬드", "인류학", 1997);
        addBook("코스모스", "칼 세이건", "과학", 1980);
        addBook("침묵의 봄", "레이첼 카슨", "환경", 1962);
    }

    public void addBook(String title, String author, String genre, int publishYear) {
        Book book = new Book(title, author, genre, publishYear);
        if (numberOfBooks >= MAX_BOOKS) {
            System.err.println("죄송합니다, 책장이 가득 찼습니다. 더 이상 추가할 수 없습니다.");
        } else {
            books[numberOfBooks] = book;
            numberOfBooks++;
        }
    }

    @Override
    public Iterator<Book> createIterator() {
        return new NonFictionBookIterator(books);
    }

    /* 설명. 내부 이터레이터 클래스 */
    private class NonFictionBookIterator implements Iterator<Book> {
        private Book[] books;
        private int position = 0;

        public NonFictionBookIterator(Book[] books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return position < books.length && books[position] != null;
        }

        @Override
        public Book next() {
            Book book = books[position];
            position++;
            return book;
        }
    }
}

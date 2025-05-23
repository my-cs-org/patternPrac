package com.ohgiraffers.pattern.chap03.behavioral.section04.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 설명. 구체적인 컨테이너 클래스
 *  - ArrayList를 사용하여 소설 도서를 저장
 */
public class FictionBookShelf implements Container<Book> {
    private List<Book> books;

    public FictionBookShelf() {
        books = new ArrayList<>();

        addBook("해리 포터와 마법사의 돌", "J.K. 롤링", "판타지", 1997);
        addBook("반지의 제왕", "J.R.R. 톨킨", "판타지", 1954);
        addBook("오만과 편견", "제인 오스틴", "고전 소설", 1813);
        addBook("1984", "조지 오웰", "디스토피아", 1949);
    }

    public void addBook(String title, String author, String genre, int publishYear) {
        Book book = new Book(title, author, genre, publishYear);
        books.add(book);
    }

    @Override
    public Iterator<Book> createIterator() {
        return new FictionBookIterator(books);
    }

    /* 설명. 내부 이터레이터 클래스 */
    private class FictionBookIterator implements Iterator<Book> {
        private List<Book> books;
        private int position = 0;

        public FictionBookIterator(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return position < books.size();
        }

        @Override
        public Book next() {
            Book book = books.get(position);
            position++;
            return book;
        }
    }
}

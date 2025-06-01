package management;

import library.Book;
import library.Member;
import datastructures.maps.CustomHashMap;

public class BookManager {
    private CustomHashMap<String, Book> books;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.books = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        if (book != null && book.getIsbn() != null) {
            this.books.put(book.getIsbn(), book);
        }
    }

    public Book getBookByIsbn(String isbn) {
        if (isbn != null) {
            return this.books.get(isbn);
        }
        return null;
    }

    public boolean isBookAvailable(String isbn) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            return book.isAvailable();
        }
        return false;
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            book.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = getBookByIsbn(isbn);
        Member member = memberManager.getMember(memberId);
        if (book != null && member != null) {
            book.addToWaitlist(member);
        }
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            return book.getNextInWaitlist();
        }
        return null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            return book.hasWaitlist();
        }
        return false;
    }
}
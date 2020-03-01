package njpo2.project.bookrepo.thread;

import njpo2.project.bookrepo.book.Book;
import njpo2.project.bookrepo.data.BookRepository;

public class BookThread extends Thread {

    private BookRepository bookRepository;
    private Book book;

    public BookThread(Book book, BookRepository bookRepository, String name){
        super(name);
        this.book = book;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run() {
        System.out.println("Wątek: "+getName()+" wpisuje do bazy...");
        synchronized (bookRepository){
            bookRepository.save(book);
        }
        System.out.println("Wątek: "+getName()+" zakończył wpisywanie.");
    }

}

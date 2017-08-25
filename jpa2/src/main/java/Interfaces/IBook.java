package Interfaces;

import Entity.Book;
import java.util.List;

public interface IBook {
    public Book createBook(Book b);
    public Book getBook(Long isbn);
    public Book updateBook(Book o);
    public Book deleteBook(Long isbn);
    public List<Book> getAllBook();
}

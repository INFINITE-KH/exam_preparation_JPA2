package Tester;

import Entity.Book;
import Facade.BookFacade;
import Interfaces.IBook;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        
        IBook ib = new BookFacade(Persistence.createEntityManagerFactory("jpaPU"));
        
        Book b1 = new Book();
        b1.setAuthor("Hanne");
        b1.setTitle("Yo Mamma");
        b1.setPrice(100.00);
        ib.createBook(b1);
        
        Book b2 = new Book();
        b2.setAuthor("Mark");
        b2.setTitle("Yo Daddy");
        b2.setPrice(100.00);
        ib.createBook(b2);
        
        System.out.println(ib.getAllBook());
    }
}

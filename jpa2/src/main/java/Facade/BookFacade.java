package Facade;

import Entity.Book;
import Interfaces.IBook;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class BookFacade implements IBook {

    private EntityManagerFactory emf;
    
    public BookFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public Book createBook(Book b) {
        EntityManager em = emf.createEntityManager();
       
        try
        {
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
            return b;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public Book getBook(Long isbn) {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Book b = em.find(Book.class, isbn);
            em.getTransaction().commit();
            return b;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public Book updateBook(Book o) {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Book bk = em.find(Book.class, o.getId());
            if( bk != null)
            {
                em.merge(o);
            }
            em.getTransaction().commit();
            return bk;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public Book deleteBook(Long isbn) {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Book b = em.find(Book.class, isbn); 
            if( b != null)
            {
                em.remove(b);
            }
            em.getTransaction().commit();
            return b;
        }
        finally
        {
            em.close();
        }
    }

    public List<Book> getAllBook() {
        EntityManager em= emf.createEntityManager();
        List<Book> books = new ArrayList();
        try
        {
            em.getTransaction().begin();
            books=em.createNamedQuery("Book.findAll").getResultList();
            em.getTransaction().commit();
            return books;
        } finally
        {
            em.close();
        }
    }
    
}

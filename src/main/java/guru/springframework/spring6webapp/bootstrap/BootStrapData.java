package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric=new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Drive Design");
        ddd.setIsbn("123456");



       // Publisher publisherSaved= publisherRepository.save(publish);

        Author ericSaved= authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);


        Author rod=new Author();
        eric.setFirstName("Rod");
        eric.setLastName("Johnson");

        Book noEJB = new Book();
        ddd.setTitle("J2EE without EJB");
        ddd.setIsbn("78910");

        Author rodSaved= authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);


        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);


        System.out.println("In BootStrap");

        System.out.println("Author count: "+ authorRepository.count());
        System.out.println("Book count: "+ bookRepository.count());


       Publisher publish= new Publisher();
        publish.setPublisherName("SpringGuru");
        publish.setAddress("Lakeshore");
        publisherRepository.save(publish);


        System.out.println("Publisher count: "+ publisherRepository.count());

    }
}

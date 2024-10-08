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
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE without EJB");
        noEJB.setIsbn("78910");

        Publisher publish= new Publisher();
        publish.setPublisherName("SpringGuru");
        publish.setAddress("Lakeshore");
        Publisher savedPublisher= publisherRepository.save(publish);

        ddd.setPublisher(savedPublisher);
        noEJB.setPublisher(savedPublisher);


        Author rodSaved= authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);


        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        dddSaved.getAuthors().add(eric);
        noEJBSaved.getAuthors().add(rod);


        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        System.out.println("In BootStrap");

        System.out.println("Author count: "+ authorRepository.count());
        System.out.println("Book count: "+ bookRepository.count());





        System.out.println("Publisher count: "+ publisherRepository.count());

    }
}

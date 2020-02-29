package njpo2.project.bookrepo.web;

import njpo2.project.bookrepo.book.Book;
import njpo2.project.bookrepo.data.BookRepository;
import njpo2.project.bookrepo.file.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;
    private FileHandler fileHandler;

    //Wstrzykiwanie BookRepository i FileHandler
    @Autowired
    public BookController(BookRepository bookRepository, FileHandler fileHandler){
        this.bookRepository = bookRepository;
        this.fileHandler = fileHandler;
    }

    //Dodaj do modelu obiekt Book
    @ModelAttribute(name = "book")
    public Book book(){
        return new Book();
    }

    //Pobierz książki
    @GetMapping
    public String showBookList(Model model){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        model.addAttribute("books",books);
        return "books";
    }

    //Dodaj książkę
    @PostMapping("/add")
    public String addBook(@ModelAttribute @Valid Book book, Errors errors){
        if(errors.hasErrors()){
            return "books";
        }
        bookRepository.save(book);
        return "redirect:/books";
    }

    //Dodaj książki z pliku
    @PostMapping
    public String addBooksFromFile(@RequestParam("file") MultipartFile file){
        List<Book> books = fileHandler.convertToBookList(fileHandler.readFromFile(file));
        for(Book book : books){
            bookRepository.save(book);
        }
        return "redirect:/books";
    }

}

package njpo2.project.bookrepo.web;

import njpo2.project.bookrepo.book.Book;
import njpo2.project.bookrepo.data.BookRepository;
import njpo2.project.bookrepo.file.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private FileHandler fileHandler;

    @GetMapping
    public String showBookList(Model model){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        model.addAttribute("books",books);
        return "books";
    }

    @PostMapping
    public String addBooksFromFile(@RequestParam("file") MultipartFile file){
        List<Book> books = fileHandler.convertToBookList(fileHandler.readFromFile(file));
        for(Book book : books){
            bookRepository.save(book);
        }
        return "redirect:/books";
    }

}

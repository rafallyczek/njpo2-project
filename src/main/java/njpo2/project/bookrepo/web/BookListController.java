package njpo2.project.bookrepo.web;

import njpo2.project.bookrepo.book.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookListController {

    @GetMapping
    public String showBookList(Model model){
        List<Book> books = Arrays.asList(
                new Book(1,"Spring w akcji","Craig Walls","IT","2019"),
                new Book(2,"Strażnik kruków","Christopher Skaife","Literatura faktu","2019"),
                new Book(3,"12 Życiowych zasad","Jordan B. Peterson","Psychologia","2018")
        );
        model.addAttribute("books",books);
        return "books";
    }

}

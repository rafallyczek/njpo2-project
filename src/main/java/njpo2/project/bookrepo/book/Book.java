package njpo2.project.bookrepo.book;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Book {

    private final int id;
    private final String title;
    private final String author;
    private final String genre;
    private final String release;

}

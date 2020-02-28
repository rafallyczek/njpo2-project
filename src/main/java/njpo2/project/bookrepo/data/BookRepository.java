package njpo2.project.bookrepo.data;

import njpo2.project.bookrepo.book.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}

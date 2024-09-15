package mockito.book_repo;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findById(Long id);
}

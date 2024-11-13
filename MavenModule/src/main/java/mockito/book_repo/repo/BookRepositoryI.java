package mockito.book_repo.repo;

import mockito.book_repo.model.Book;

import java.util.Optional;

public interface BookRepositoryI {
    Optional<Book> findById(Long id);
}

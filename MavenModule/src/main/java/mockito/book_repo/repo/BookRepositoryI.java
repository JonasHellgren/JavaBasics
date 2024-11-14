package mockito.book_repo.repo;

import mockito.book_repo.domain.Book;

import java.util.Optional;

public interface BookRepositoryI {
    Optional<Book> findById(Long id);
}

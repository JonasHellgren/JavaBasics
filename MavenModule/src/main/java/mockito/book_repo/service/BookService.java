package mockito.book_repo.service;

import mockito.book_repo.repo.BookRepositoryI;

import java.util.List;
import java.util.Optional;


public class BookService {
    private final BookRepositoryI bookRepository;

    public BookService(BookRepositoryI bookRepository) {
        this.bookRepository = bookRepository;
    }

    public double calculateTotalCost(List<Long> bookIds) {
        return bookIds.stream()
                .map(bookRepository::findById)
                .filter(Optional::isPresent)
                .mapToDouble(book -> book.get().price())
                .sum();
    }
}

package mockito.book_repo;

import java.util.List;
import java.util.Optional;


public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
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

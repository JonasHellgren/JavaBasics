package mockito;



import lombok.NonNull;
import mockito.book_repo.model.Book;
import mockito.book_repo.repo.BookRepositoryI;
import mockito.book_repo.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

class TestBookService {

    @Test
     void testCalculateTotalCost() {
        var bookRepository = getMockedBookRepository();
        var bookService = new BookService(bookRepository);
        double totalCost = bookService.calculateTotalCost(Arrays.asList(1L, 2L));

        Assertions.assertEquals(25.0, totalCost);
        verify(bookRepository, times(1)).findById(1L);
        verify(bookRepository, times(1)).findById(2L);
    }

    private static @NonNull BookRepositoryI getMockedBookRepository() {
        BookRepositoryI bookRepository = mock(BookRepositoryI.class);
        Book book1 = new Book(1L, "Book 1", 10.0);
        Book book2 = new Book(2L, "Book 2", 15.0);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book1));
        when(bookRepository.findById(2L)).thenReturn(Optional.of(book2));
        return bookRepository;
    }
}

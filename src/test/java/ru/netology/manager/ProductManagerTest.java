package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductManagerTest {
    Book book1 = new Book(01, "Amber", 66, "Zelazny");
    Book book2 = new Book(02, "A Farewell to Arms", 1, "Hemingway");
    Book book3 = new Book(03, "Cajita de música", 180, "Alfaro");
    Book book4 = new Book(04, "Россия", 400, "Перевезенцев");
    Book book5 = new Book(05, "Dream master", 199, "Zelazny");
    Product product1 = new Product(06, "Meat", 500);
    Smartphone smartphone1 = new Smartphone(01, "Iphone", 9999, "USA");
    Smartphone smartphone2 = new Smartphone(02, "Samsung", 139, "Korea");
    Smartphone smartphone3 = new Smartphone(03, "Xiaomi", 90, "China");
    Smartphone smartphone4 = new Smartphone(04, "Beeline", 899, "Россия");

    @Test
    public void shouldRemoveProduct() {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.removeById(003);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneBook() {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(product1);

        assertThrows(NotFoundException.class, () -> {repo.removeById(19);});
    }
}

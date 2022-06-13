package Product.Manager;

import Product.Book;
import Product.Product;
import Product.Repository.ProductRepository;
import Product.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(001,"Возрождение",1000,"Данке");
    private Book second = new Book(002,"Кто ты",245,"Gord");
    private Book third = new Book(003,"Голая правда",450,"Горд");
    private Book fourth = new Book(004,"Голая правда",450,"Горд");
    private Book fifth = new Book(005,"Автоматизированное тестирование программного обеспечения",1000,"Элфрид Дастин, Джефф Рэшка, Джон Пол");
    private Smartphone sixth = new Smartphone(006,"S22",59000,"Samsung");
    private Smartphone seventh = new Smartphone(007,"T9",25000,"Xiaomi");
    private Smartphone eidhth = new Smartphone(00,"7X",18000,"Huawei");
    private Smartphone ninth = new Smartphone(00,"N990",10000,"Nokia");
    private Smartphone tenth = new Smartphone(010,"Z7",16000,"Sony");


    @BeforeEach
    public void setup() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(sixth);
        manager.add(seventh);


    }

    @Test // Тест поиска с одинаковыми данными
    public void shouldUseEquals() {
        Product third = new Book(003, "Голая правда",450,"Горд");
        Product fourth = new Book(003, "Голая правда",450,"Горд");
        assertEquals(third, fourth);
    }

    @Test // Тест поиск всего списка
    void shouldGetAll() {
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, second, third, fourth,sixth,seventh};
        assertArrayEquals(expected, actual);
    }
    @Test // Тест поиск книги по автору
    public void shouldFindAuthorExistBook() {
        Product[] actual = manager.searchBy("Данке");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test // Тест поик книги по названию
    public void shouldFindByBookName() {
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Кто ты");
        assertArrayEquals(expected, actual);
    }

    @Test //Тест поиска книги по автору которой нет в списке
    void shouldFindAuthoNotExistBook() {
        manager.add(first);
        Product[] actual = manager.searchBy("Пушкин");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test //Тест поиска книги по названию которой нет в списке
    void shouldFindNameNotExistBook() {
        manager.add(second);
        Product[] actual = manager.searchBy("Война и Мир");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test //Тест поиска телефон по модели
    public void shouldFindBySmartphoneManufacturer() {
        Product[] expected = new Product[]{sixth};
        Product[] actual = manager.searchBy("S22");
        assertArrayEquals(expected, actual);
    }

    @Test // Тест поиска телефон по производител.
    public void shouldFindBySmartphoneTitle() {
        Product[] expected = new Product[]{sixth};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test //Тест поиска смартфона по производителю которого нет в списке
    void shouldFindМanufacturerNotExistSmartphone() {
        manager.add(sixth);
        Product[] actual = manager.searchBy("BQ");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test //Тест поиска смартфона по названию модели которой нет в списке
    void shouldFindNameNotExistSmartphone() {
        manager.add(sixth);
        Product[] actual = manager.searchBy("Iphone 11");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
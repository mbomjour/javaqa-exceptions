import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.NotFoundException;

public class ShopRepositoryTest {

    Product item1 = new Product(1, "Молоко", 50);
    Product item2 = new Product(2, "Хлеб", 23);
    Product item3 = new Product(3, "Соль", 30);

    ShopRepository repo = new ShopRepository();

    @BeforeEach
    public void setup() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
    }

    @Test
    public void removeIfFoundId() {
        repo.removeById(1);

        Product[] expected = {item2, item3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void exceptionIfNotFoundId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }
}
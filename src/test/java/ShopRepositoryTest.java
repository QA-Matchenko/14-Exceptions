import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ShopRepositoryTest {

    @Test
    public void testRemoveIfProductExists() {
        ShopRepository repo= new ShopRepository();
        Product product1 = new Product(1, "каска", 23000);
        Product product2 = new Product(2, "сноуборд", 80000);
        Product product3 = new Product(3, "комбинезон зимний", 37000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveIfProductNotExists() {
        ShopRepository repo= new ShopRepository();
        Product product1 = new Product(1, "каска", 23000);
        Product product2 = new Product(2, "сноуборд", 80000);
        Product product3 = new Product(3, "комбинезон зимний", 37000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(563454376));
    }


}
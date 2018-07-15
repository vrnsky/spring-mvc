package service;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

/**
 * Update all stock at the web store.
 * @author vrsnky.
 * @version 0.1.
 */
@Service
public class UpdateStockImpl implements UpdateService {

    /**
     * Product repository.
     */
    @Autowired
    private ProductRepository repository;

    /**
     * Check that some goods have many 500 counts and update it by plus 1000 to current count.
     */
    @Override
    public void updateAllStocks() {
        List<Product> products = this.repository.getAllProducts();
        for (Product product : products) {
            if (product.getUnitsInStock() < 500) {
                repository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
            }
        }
    }
}

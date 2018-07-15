package repository;


import domain.Product;

import java.util.List;

/**
 * Repository interface for all entites.
 * @author vrnsky.
 * @version 0.1.
 */
public interface ProductRepository {

    /**
     * Get all products from repository.
     * @return return all products.
     */
    List<Product> getAllProducts();

    /**
     * Update stock at the database.
     * @param productId of product for update.
     * @param count how many we add.
     */
    void updateStock(String productId, long count);
}

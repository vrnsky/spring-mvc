package repository;


import domain.Product;

import java.util.List;
import java.util.Map;

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


    /**
     * Return products by category.
     * @param category string view of category.
     * @return list of products which related to the given directory.
     */
    List<Product> getProductsByCategory(String category);

    /**
     * Load products by some parameters and return it.
     * @return list of all products which related to the give paramter.
     */
    List<Product> getProductsByFilters(Map<String, List<String>> params);
}

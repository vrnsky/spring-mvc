package service;

import domain.Product;

import java.util.List;

/**
 * Product service, it is wrapper for repository object.
 */
public interface ProductService {

    /**
     * Return all products.
     * @return list of all products.
     */
    List<Product> getAllProducts();

    /**
     * Return a list of product which have given category.
     * @param category string of searchable category.
     * @return list of product which related to the category.
     */
    List<Product> getProductsByCategory(String category);
}

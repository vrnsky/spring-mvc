package service;

import domain.Product;

import java.util.List;
import java.util.Map;

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


    /**
     * Return list of product which have a special parameter.
     * @param params list of categories and brands.
     * @return list of products which have required characterict.
     */
    List<Product> getProductsByParams(Map<String, List<String>> params);

    /**
     * Return a product with given id or null.
     * @param id unique per each product string.
     * @return product instance or null.
     */
    Product getProductById(String id);

    /**
     * Add new product to the system.
     * @param product instance of the product class.
     */
    void addProduct(Product product);


}

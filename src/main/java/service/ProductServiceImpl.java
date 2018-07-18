package service;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    /**
     * Product repository for execute some operations
     */
    private ProductRepository productRepo;

    /**
     * Create a new service for product operation.
     * @param repository implemnetation of product repository interface.
     */
    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.productRepo = repository;
    }

    /**
     * Return all products from the repository.
     * @return list of all products.
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepo.getAllProducts();
    }

    /**
     * Return products with given category.
     * @param category string of searchable category.
     * @return list of all products which have category is equals given category.
     */
    @Override
    public List<Product> getProductsByCategory(String category) {
        return this.productRepo.getProductsByCategory(category);
    }

    /**
     * Extract from the repository products which have related to the given param.
     * @param params list of categories and brands.
     * @return list of products which related to the given params.
     */
    @Override
    public List<Product> getProductsByParams(Map<String, List<String>> params) {
        return this.productRepo.getProductsByFilters(params);
    }

    /**
     * Return a product from the database.
     * @param id unique per each product string.
     * @return instance of the product.
     */
    @Override
    public Product getProductById(String id) {
        return this.productRepo.getProductById(id);
    }

    /**
     * Adding a new product to the system.
     * @param product instance of the product class.
     */
    @Override
    public void addProduct(Product product) {
        this.productRepo.addProduct(product);
    }
}

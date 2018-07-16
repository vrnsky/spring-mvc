package service;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

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
}

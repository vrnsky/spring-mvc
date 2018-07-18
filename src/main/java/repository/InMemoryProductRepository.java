package repository;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Product repository which allow to CRUD operation with product.
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {


    /**
     * JDBC object.
     */
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    /**
     * Return all product from database.
     * @return list of all products.
     */
    @Override
    public List<Product> getAllProducts() {
        Map<String, Object> params = new HashMap<>();
        List<Product> products = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
        return products;
    }

    /**
     * Update stock at the app.
     * @param productId of product which will be updated.
     * @param count how many we add products.
     */
    @Override
    public void updateStock(String productId, long count) {
        Map<String, Object> params = new HashMap<>();
        params.put("count", count);
        params.put("productId", productId);
        jdbcTemplate.update("UPDATE products SET units_in_stock = :count where id = :productId", params);
    }

    /**
     * Getting products from database which category is equals to given category.
     * @param category string object which describe category.
     * @return list of product which have given directory.
     */
    @Override
    public List<Product> getProductsByCategory(String category) {
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        return jdbcTemplate.query("SELECT * FROM products WHERE category = :category", params, new ProductMapper());
    }


    /**
     * Return a product which have required category and brand.
     * @param params list of categories and brands.
     * @return list of product which related to the required category and brand.
     */
    @Override
    public List<Product> getProductsByFilters(Map<String, List<String>> params) {
        String SQL = "SELECT * FROM products where category in ( :categories) and manufacturer in ( :brands)";
        return jdbcTemplate.query(SQL, params, new ProductMapper());
    }

    /**
     * Return product which given related id.
     * @param id unique per each produt string.
     * @return instance of product from the database.
     */
    @Override
    public Product getProductById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = :id", params, new ProductMapper());
    }

    /**
     * Adding new product to the system.
     * @param product instance of product class.
     */
    @Override
    public void addProduct(Product product) {
        String SQL = "INSERT INTO products (id, name, description, unit_price, manufacturer, category, condition, units_in_stock, units_in_order, discounted)" +
                " values (:id, :name, :description, :unit_price, :manufacturer, :category, :condition, :units_in_stock, :units_in_order, :discounted)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", product.getProductId());
        params.put("name", product.getName());
        params.put("category", product.getCategory());
        params.put("description", product.getDescription());
        params.put("unit_price", product.getUnitPrice());
        params.put("manufacturer", product.getManufacturer());
        params.put("condition", product.getCondition());
        params.put("units_in_stock", product.getUnitsInStock());
        params.put("units_in_order", product.getUnitsInOrder());
        params.put("discounted", product.isDiscounted());
        this.jdbcTemplate.update(SQL, params);
    }


    /**
     * Class which allow to map result set to the domain object.
     */
    private static final class ProductMapper implements RowMapper<Product> {
        /**
         * Create a new domain object with data extract from the database.
         * @param rs sequence of the result.
         * @param i iteration integer.
         * @return instance of domain object.
         * @throws SQLException throw if something was wrong.
         */
        @Override
        public Product mapRow(ResultSet rs, int i) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getString("id"));
            product.setName(rs.getString("name"));
            product.setDescription(rs.getString("description"));
            product.setUnitPrice(rs.getBigDecimal("unit_price"));
            product.setCategory(rs.getString("category"));
            product.setManufacturer(rs.getString("manufacturer"));
            product.setCondition(rs.getString("condition"));
            product.setUnitsInStock(rs.getLong("units_in_stock"));
            product.setUnitsInOrder(rs.getLong("units_in_order"));
            product.setDiscounted(rs.getBoolean("discounted"));
            return product;
        }
    }
}

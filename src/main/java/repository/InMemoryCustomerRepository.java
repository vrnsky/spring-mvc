package repository;


import domain.Customer;
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
 * In memory customer repository, hold all data in embedded database.
 * @author vrnsky.
 * @version 0.1.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    /**
     * Spring object for interact with database.
     */
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Create a new storage with given template.
     * @param jdbcTemplate jdbc template.
     */
    @Autowired
    public InMemoryCustomerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Add customer to the database.
     * @param customer instnace of the customer class.
     */
    public void addCustomer(Customer customer) {
        Map<String, Object> param = new HashMap<>();
        param.put("id", customer.getId());
        param.put("name", customer.getName());
        param.put("address", customer.getAddress());
        param.put("count", customer.getOrderMakes());
        jdbcTemplate.update("INSERT INTO customers (id, name, address, makesOrder) values (:id, :name, :address, :count)", param);
    }

    /**
     * Return list of all customers.
     * @return list of all customers.
     */
    public List<Customer> getAllCustomers() {
       return jdbcTemplate.query("SELECT * FROM customers", new CustomerMapper());
    }


    /**
     * Class for mapping customer.
     * @author vrnsky.
     * @version 0.1.
     */
    private static final class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int i) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getString("id"));
            customer.setName(rs.getString("name"));
            customer.setAddress(rs.getString("address"));
            customer.setOrderMakes(rs.getInt("makesOrder"));
            return customer;
        }
    }



}

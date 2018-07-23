package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Domain object which describe a product which will sell at the app.
 * @author vrnsky.
 * @version 0.1.
 */
@Data @NoArgsConstructor
@XmlRootElement
public class Product {

    /**
     * Unique per product number.
     */
    private String productId;

    /**
     * Name of the good.
     */
    private String name;

    /**
     * Price for this good.
     */
    private BigDecimal unitPrice;

    /**
     * Description of the good.
     */
    private String description;

    /**
     * Manufacturer of this good.
     */
    private String manufacturer;

    /**
     * Category of the good.
     */
    private String category;

    /**
     * How many we have at the warehouse.
     */
    private long unitsInStock;

    /**
     * How many user ordered.
     */
    private long unitsInOrder;

    /**
     * Now is sell with discount if it true.
     */
    private boolean discounted;

    /**
     * Condition of the product - new or refurbished.
     */
    private String condition;


    /**
     * Image of the product.
     */
    @XmlTransient
    @JsonIgnore
    private MultipartFile image;


    /**
     * Manual for product.
     */
    @XmlTransient
    @JsonIgnore
    private MultipartFile manual;

    /**
     * Create a new product with given id and name, price.
     * @param productId unique per products number.
     * @param name of good.
     * @param unitPrice of good.
     */
    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    /**
     * Good is same when id is equals.
     * @param o for compare.
     * @return true if id is equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId());
    }

    /**
     * Hash code function.
     * @return some numbers.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getProductId());
    }

    @XmlTransient @JsonIgnore
    public MultipartFile getImage() {
        return this.image;
    }

    @XmlTransient @JsonIgnore
    public MultipartFile getManual() {
        return this.manual;
    }
}

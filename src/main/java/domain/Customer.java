package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Domain object which describe an customer in real life.
 * @author vrnsky.
 * @version 0.1;
 */
@Data @NoArgsConstructor
public class Customer {

    /**
     * Unique per user number.
     */
    private String id;

    /**
     * Name of user.
     */
    private String name;

    /**
     * Address of the user.
     */
    private String address;

    /**
     * How many orders customer makes.
     */
    private int orderMakes;
}

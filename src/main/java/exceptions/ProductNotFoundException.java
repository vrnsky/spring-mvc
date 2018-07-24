package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductNotFoundException extends RuntimeException {

    private String id;

    public ProductNotFoundException(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}

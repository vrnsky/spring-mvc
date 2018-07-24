package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception thrown when app does not a found category in the database.
 * @author Egor Voronyansky
 * @version 0.1
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found under this directory")
public class NoProductsFoundUnderCategoryException extends RuntimeException {
}

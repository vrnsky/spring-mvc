package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ProductRepository;
import service.UpdateService;

/**
 * Controller for products.
 * @author vrnsky.
 * @version 0.1.
 */
@Controller
public class ProductController {


    /**
     * Repository of products.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Service for update some details of product.
     */
    @Autowired
    private UpdateService updateService;

    /**
     * Give all products from persistence layer.
     * @param model of the spring.
     * @return user to the products page.
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", this.productRepository.getAllProducts());
        return "products";
    }

    /**
     * Update stock at the app.
     * @return user to the products page with updated data.
     */
    @RequestMapping(value = "/update/stocks", method = RequestMethod.GET)
    public String updateStocks() {
        updateService.updateAllStocks();
        return "redirect:/products";
    }
}

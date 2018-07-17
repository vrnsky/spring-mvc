package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ProductService;
import service.UpdateService;

import java.util.List;
import java.util.Map;

/**
 * Controller for products.
 *
 * @author vrnsky.
 * @version 0.1.
 */
@Controller
@RequestMapping("/market")
public class ProductController {


    /**
     * Repository of products.
     */
    @Autowired
    private ProductService productService;

    /**
     * Service for update some details of product.
     */
    @Autowired
    private UpdateService updateService;

    /**
     * Give all products from persistence layer.
     *
     * @param model of the spring.
     * @return user to the products page.
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "products";
    }

    /**
     * Update stock at the app.
     *
     * @return user to the products page with updated data.
     */
    @RequestMapping(value = "/update/stocks", method = RequestMethod.GET)
    public String updateStocks() {
        updateService.updateAllStocks();
        return "redirect:/market/products";
    }

    /**
     * Getting products by category.
     *
     * @param category string view of category.
     * @param model    object of spring mvc.
     * @return show user all products which have given category
     */
    @RequestMapping(value = "/products/{category}", method = RequestMethod.GET)
    public String getProductsByCategory(@PathVariable String category, Model model) {
        model.addAttribute("products", this.productService.getProductsByCategory(category));
        return "products";
    }

    /**
     * Get products by some parameters
     * @param filterParams all paramaters and its values.
     * @param model spring object.
     * @return user to the products page which related to the given directory.
     */
    @RequestMapping(value = "/products/filter/{params}", method = RequestMethod.GET)
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", this.productService.getProductsByParams(filterParams));
        return "products";
    }
}

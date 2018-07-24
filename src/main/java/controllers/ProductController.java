package controllers;

import domain.Product;
import exceptions.NoProductsFoundUnderCategoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.ProductService;
import service.UpdateService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
        List<Product> products = this.productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    /**
     * Get products by some parameters
     *
     * @param filterParams all paramaters and its values.
     * @param model        spring object.
     * @return user to the products page which related to the given directory.
     */
    @RequestMapping(value = "/products/filter/{params}", method = RequestMethod.GET)
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", this.productService.getProductsByParams(filterParams));
        return "products";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", this.productService.getProductById(productId));
        return "product";
    }

    /**
     * Return to the client page which allow to add a new product to the shop.
     * @param model instance of spring mvc.
     * @return user to the addproduct view.
     */
    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String getAddNewProductFrom(Model model) {
        Product newProduct = new Product();
        model.addAttribute("product", newProduct);
        return "addproduct";
    }

    /**
     * Add new product to the system.
     * @param newProduct instance of the new product.
     * @return user to the main page of products.
     */
    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("product") Product newProduct, BindingResult result, HttpServletRequest request) {
        String[] suppresedFields = result.getSuppressedFields();
        if (suppresedFields.length > 0) {
            throw new RuntimeException("Attempting to disallowed fields "  + StringUtils.arrayToCommaDelimitedString(suppresedFields));
        }
        MultipartFile image = newProduct.getImage();
        MultipartFile manual = newProduct.getManual();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (image != null && !image.isEmpty()) {
            try {
                image.transferTo(new File(rootDirectory + "\\resources\\images\\" + newProduct.getProductId() + ".jpg"));
                manual.transferTo(new File(rootDirectory + "\\resources\\manuals\\" + newProduct.getProductId() + ".pdf"));
            } catch (IOException ioex) {
                throw new RuntimeException("Image loading failed", ioex);
            }
        }
        this.productService.addProduct(newProduct);
        return "redirect:/market/products";
    }

    /**
     * White list for product mapping.
     * @param binder instance of binder for configure.
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields(
                "productId",
                "name",
                "description",
                "unitPrice",
                "category",
                "manufacturer",
                "unitsInStock",
                "condition",
                "image",
                "manual"
        );
    }

}

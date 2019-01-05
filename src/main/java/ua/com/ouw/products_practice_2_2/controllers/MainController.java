package ua.com.ouw.products_practice_2_2.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.ouw.products_practice_2_2.models.Product;
import ua.com.ouw.products_practice_2_2.service.ProductService;

@Controller
@AllArgsConstructor
public class MainController {

    private ProductService productService;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("products", productService.shawAll());
        return "index";
    }

    @GetMapping("/saved")
    public String save() {
        return "save";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("products", productService.shawAll());
        return "allProducts";
    }

    @GetMapping("/mainP")
    public String toMainPage() {
        return "redirect:/";
    }

    @GetMapping("/moreExpThan1000")
    public String moreThan1000(Model model) {
        model.addAttribute("products", productService.priceHigherThen1000());
        return "allProducts";
    }

    @GetMapping("/moreThan2000")
    public String moreThan2000(Model model) {
        model.addAttribute("products", productService.priceHigherThen2000());
        return "allProducts";
    }

    @GetMapping("/last10")
    public String last10Products(Model model){
        model.addAttribute("products", productService.showLast10Added());
        return "allProducts";
    }

    @GetMapping("/orderedByName")
    public String orderedByName(Model model){
        model.addAttribute("products", productService.showAllSorted());
        return "allProducts";
    }
}

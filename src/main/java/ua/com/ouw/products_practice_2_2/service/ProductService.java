package ua.com.ouw.products_practice_2_2.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import ua.com.ouw.products_practice_2_2.dao.ProductDAO;
import ua.com.ouw.products_practice_2_2.models.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void save(Product product) {
        productDAO.save(product);
    }

    public List<Product> shawAll() {
        List<Product> all = productDAO.findAll();
        return all;
    }

    public List<Product> priceHigherThen1000() {
        List<Product> products = productDAO.priseHigherThen(1000);
        return products;
    }

    public List<Product> priceHigherThen2000() {
        List<Product> products = productDAO.getByPriceGreaterThan(2000);
        return products;
    }

    public List<Product> showLast10Added() {
        List<Product> productList = productDAO.showLast10();
        List<Product> collect = productList.stream().limit(10).collect(Collectors.toList());
        return collect;
    }

    public List<Product> showAllSorted() {
        return productDAO.orderByName();
    }

}

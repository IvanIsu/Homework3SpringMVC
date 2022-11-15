package com.isupov.springmvc.api;

import com.isupov.springmvc.model.Product;
import com.isupov.springmvc.model.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/products")
public class productController {

    private ProductRepository productRepository;

    @PostConstruct
    public void init(){
        productRepository = new ProductRepository();
        productRepository.addProductRepository(new Product(1,"One",11.22));
        productRepository.addProductRepository(new Product(2,"Two",22.22));
        productRepository.addProductRepository(new Product(3,"Three",33.22));
        productRepository.addProductRepository(new Product(4,"Four",44.22));
        productRepository.addProductRepository(new Product(5,"Five",55.22));

    }

    @GetMapping()

    public String printProducts(Model model){
        model.addAttribute("products", productRepository.getProductRepository());
        return "productsList";

    }

    @GetMapping("/add")
    public String addProducts(Model model){
        model.addAttribute("products", productRepository.getProductRepository());
        return "addProduct";
    }

    @GetMapping("/add/new")
    public String addNewProducts(@RequestParam String title, String cost, Model model){


        if(title != null && cost != null){
            double v;
            try {
               v = Double.parseDouble(cost);
            }catch (Exception e){
                return "badRequest";
            }
            int id = productRepository.getSize();
            productRepository.addProductRepository(new Product(++id,title, v));
            return "addProduct";
        }else return "badRequest";
    }

    @GetMapping("/{id}")
    public String printProduct(@PathVariable Long id, Model model){
        long testID = id;
        if(productRepository.getProductRepositoryForID(testID).isPresent()){
            model.addAttribute("product",productRepository.getProductRepositoryForID(testID).get());
            return "product";
        }else {
            return "badRequest";
        }

    }
}

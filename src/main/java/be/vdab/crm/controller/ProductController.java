package be.vdab.crm.controller;

import be.vdab.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.expression.Mvc;

import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private Mvc mvc;

    @GetMapping("/list")
    public String getAllProducts(Map<String,Object> model) {
        model.put("productList", service.getAllProducts());
        return "product-list";
    }


}

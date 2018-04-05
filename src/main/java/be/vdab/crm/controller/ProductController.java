package be.vdab.crm.controller;

import be.vdab.crm.entity.Product;
import be.vdab.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "/create-or-edit")
    public String createAndEditForm(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> model) {
        model.put("productForm", new Product());
        return "product-edit-create";
    }

//    @PostMapping(path = "/create-or-edit")
//    public String createAndEditFormSubmit(@ModelAttribute("productForm") Product product, BindingResult br) {
//        if(br.hasErrors()) {
//            return "product-edit-create";
//        } else {
//            service.save(product);
//            System.out.println("DO WORK");
//            return "redirect:/products/list"; // mvc gebruiken?? mvc.url(...)
//        }
//
//    }

    @PostMapping(path = "/create-or-edit")
    public String createAndEditFormSubmit(@ModelAttribute("productForm") Product product, BindingResult br) {
        if((br.hasErrors()) || (product.getName()==null) || (product.getPrice()==0) || (product.getCategory()==null)) {
              return "product-edit-create";
        } else {
            service.save(product);
            System.out.println("DO WORK");
            return "redirect:/products/list"; // mvc gebruiken?? mvc.url(...)
        }

    }


}

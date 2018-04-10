package be.vdab.crm.controller;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.entity.Product;
import be.vdab.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;
>>>>>>> Added quote/list and quote/details
import javax.validation.Valid;
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

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        model.put("product", service.getProductById(id));
        return "product-details";
    }

<<<<<<< HEAD
    @GetMapping(path = "/create-or-edit")
    public String createOrEditForm(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> model) {
        Product p = id == null ? new Product() : service.getProductById(id);
        model.put("productForm", p);
=======
    @GetMapping(path = {"/create-or-edit/{id}", "/create-or-edit"})
    public String createOrEditForm(@PathVariable(required = false) Integer id, Map<String, Object> model) {
        model.put("productForm", (id == null ? new Contact() : service.getProductById(id)));
>>>>>>> Added quote/list and quote/details
        return "product-edit-create";
    }

//    @PostMapping(path = "/create-or-edit")
//    public String createOrEditFormSubmit(@ModelAttribute("productForm") Product product, BindingResult br) {
//        if(br.hasErrors()) {
//            return "product-edit-create";
//        } else {
//            service.save(product);
//            System.out.println("DO WORK");
//            return "redirect:/products/list"; // mvc gebruiken?? mvc.url(...)
//        }
//
//    }

<<<<<<< HEAD
    @PostMapping(path = "/create-or-edit")
    public String createOrEditFormSubmit(@ModelAttribute("productForm") @Valid Product product, BindingResult br) {
=======

    @PostMapping(path = {"/create-or-edit/{id}", "/create-or-edit"})
    public String createOrEditFormSubmit(@ModelAttribute("productForm") @Valid Product product, BindingResult br
            , Map < String, Object > model, HttpServletRequest req) {
>>>>>>> Added quote/list and quote/details
        if((br.hasErrors()) || (product.getName()==null) || (product.getPrice()==0) || (product.getCategory()==null)) {
              return "product-edit-create";
        } else {
            service.save(product);
   //         System.out.println("DO WORK");
            return "redirect:/products/list"; // mvc gebruiken?? mvc.url(...)
        }

    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET},path = "/remove")
    public String remove(@RequestParam int id){
        service.delete(id);
        return "redirect:/products/list";
    }


}

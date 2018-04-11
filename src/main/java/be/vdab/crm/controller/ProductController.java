package be.vdab.crm.controller;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.entity.Product;
import be.vdab.crm.entity.User;
import be.vdab.crm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import javax.servlet.http.HttpServletRequest;
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


//    @GetMapping(path = {"/create-or-edit/{id}", "/create-or-edit"})
//    public String createOrEditForm(@PathVariable(required = false) Integer id, Map<String, Object> model) {
//        model.put("productForm", (id == null ? new Product() : service.getProductById(id)));
//        return "product-edit-create";
//    }

    @GetMapping("/create-or-edit")
    public String createOrEditForm(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> model) {
        Product p = id == null ? new Product() : service.getProductById(id);
        model.put("productForm", p);
        return "product-edit-create";
    }

    @PostMapping("/create-or-edit")
    public String createOrEditFormSubmit(@ModelAttribute("productForm") Product product, BindingResult br) {
     //   if((br.hasErrors()) || (product.getName()==null) || (product.getUnitPrice()==0) || (product.getCategory()==null)) {
        if(br.hasErrors()) {
            return "product-edit-create";
        } else {   //setId required !
            System.out.println("SAVE PRODUCT");
            service.save(product);
            return "redirect:/products/list";
        }
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET},path = "/remove")
    public String remove(@RequestParam int id){
        service.delete(id);
        return "redirect:/products/list";
    }


}

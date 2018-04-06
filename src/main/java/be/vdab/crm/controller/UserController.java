package be.vdab.crm.controller;

import be.vdab.crm.entity.Product;
import be.vdab.crm.entity.User;
import be.vdab.crm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

   // private static final String ROOT = "users/";

    @Autowired
    Mvc mvc;

    @Autowired
    private UserService service;

    @GetMapping("/list")
    public String list(Map<String,Object> model) {
        model.put("userList", service.getAllUsers());
        return "user-list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Map<String, Object> model) {
        model.put("user", service.getUserById(id));
        return "user-details";
    }

    @GetMapping(path = "/create-or-edit")
    public String createAndEditForm(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> model) {
        model.put("userForm", new User());
        return "user-edit-create";
    }

    @PostMapping(path = "/create-or-edit")
    public String createAndEditFormSubmit(@ModelAttribute("userForm") User user, BindingResult br) {
        if(br.hasErrors()) {
            return "user-edit-create";
        } else {
            service.save(user);
            return "redirect:/users/list";
        //    return "redirect:" + mvc.url("UC#list").build();
        }
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET},path = "/remove")
    public String remove(@RequestParam int id){
        service.delete(id);
        return "redirect:/users/list";
  //      return "redirect:" + mvc.url("UC#list").build();
    }

}

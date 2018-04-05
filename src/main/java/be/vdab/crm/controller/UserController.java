package be.vdab.crm.controller;

import be.vdab.crm.entity.Product;
import be.vdab.crm.entity.User;
import be.vdab.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import java.util.Map;

@Controller
//@RequestMapping("/users")
public class UserController {
    private static final String ROOT = "users/";
    @Autowired
    Mvc mvc;

    @Autowired
    private UserService userService;

    @RequestMapping(ROOT + "list")
    public String list(Map<String, Object> model) {
        model.put("userList", userService.getAllUsers());
        return "user-list";    //
    }

    @RequestMapping(ROOT + "details/{id}")
    public String details(@PathVariable(value = "id") int id, Map<String, Object> model) {
        model.put("user", userService.lookupUser(id));
        return "user-details";
    }

    @RequestMapping(path= ROOT + "create-or-edit", method = RequestMethod.GET)
    public String createAndEditForm(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> model) {
        User u = id == null ? new User() : userService.lookupUser(id);
        model.put("userForm", u);
        return "user-edit-create";
    }



}

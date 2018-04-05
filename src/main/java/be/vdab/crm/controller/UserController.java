package be.vdab.crm.controller;

import be.vdab.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.expression.Mvc;

import java.util.Map;

@Controller
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


}

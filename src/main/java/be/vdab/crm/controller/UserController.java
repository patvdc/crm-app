package be.vdab.crm.controller;

import be.vdab.crm.entity.Product;
import be.vdab.crm.entity.User;
import be.vdab.crm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Mvc mvc;

    @Autowired
    private UserService userService;

    @Autowired   //interface
    private PasswordEncoder pswEncoder;

    @GetMapping("/list")
    public String list(Map<String,Object> model) {
        model.put("userList", userService.getAllUsers());
        return "user-list";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        model.put("user", userService.getUserById(id));
        return "user-details";
    }

    @GetMapping("/create-or-edit")
    public String createOrEditUserForm(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> model) {
        User u = id == null ? new User() : userService.getUserById(id);
        model.put("userForm", u);
        return "user-edit-create";
    }

    @PostMapping("/create-or-edit")
    public String createOrEditUserFormSubmit(@ModelAttribute("userForm") @Valid User user, BindingResult br) {

        if(br.hasErrors()) {
            return "user-edit-create";
        } else {
            user.setPassword(pswEncoder.encode(user.getPassword()));
            userService.save(user);
            return "redirect:/users/list";
        //    return "redirect:" + mvc.url("UC#list").build();
        }
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET},path = "/remove")
    public String remove(@RequestParam int id){
        userService.delete(id);
        return "redirect:/users/list";
  //      return "redirect:" + mvc.url("UC#list").build();
    }

}

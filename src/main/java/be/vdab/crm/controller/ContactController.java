package be.vdab.crm.controller;

import be.vdab.crm.entity.Contact;
import be.vdab.crm.entity.Phone;
import be.vdab.crm.entity.PhoneType;
import be.vdab.crm.service.ContactService;
import be.vdab.crm.service.ProductService;
import be.vdab.crm.service.QuoteService;
import be.vdab.crm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.expression.Mvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;
    @Autowired
    private Mvc mvc;
    @Autowired
    private QuoteService quoteservice;
    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public String listAllContacts(Map<String, Object> model) {
        model.put("contactList", contactService.getAllContacts());
        return "contact-list";
    }

    @GetMapping({"edit-create/{id}", "edit-create"})
    public String editOrCreateContactRequest(@PathVariable(required = false) Integer id, Map<String, Object> model) {
        model.put("contact", (id == null ? new Contact() : contactService.findContactById(id)));
        model.put("owners", userService.getAllUsers());
        return "contact-edit-create";
    }

    @GetMapping("details/{id}")
    public String contactDetails(@PathVariable Integer id, Map<String, Object> model) {
        model.put("contact", contactService.findContactById(id));
        model.put("quoteList", quoteservice.getAllQuotesByContactId(id));
        model.put("products", productService.getAllProducts());
        return "contact-details";
    }
    //used pathvariable instead
//    @GetMapping("edit-create")
//    public String editOrCreateContactRequest(@RequestParam(value="id", required = false) Integer id, Map<String, Object> model) {
//        model.put("contact", (id == null ? new Contact() : contactService.findContactById(id)));
//        model.put("owners", userService.getAllUsers());
//        return "contact-edit-create";
//    }


    @PostMapping({"edit-create/{id}", "edit-create"})
    public String editOrCreateContactPost(@ModelAttribute("contact") @Valid Contact contact, BindingResult br
            , Map<String, Object> model, HttpServletRequest req) {

        takeCareOfPhoneNumberMumboJumbo(contact, req, br);

        extraValidation(contact, br, req);

        if (br.hasErrors()) {
            model.put("owners", userService.getAllUsers());
            return "contact-edit-create";
        } else {
            contactService.save(contact);
            return "redirect:" + mvc.url("CC#contactDetails").arg(0, contact.getId()).build();
        }
    }

    private void takeCareOfPhoneNumberMumboJumbo(Contact contact, HttpServletRequest req, BindingResult br) {

        /**
         * To get contact phone map. Since phones is not bounded by th:field the contact object posted
         * to the controller does not contain the phones map
         * */
        if (contact.getId() != null) {
            contact.getPhones().putAll(contactService.findContactById(contact.getId()).getPhones());
        }

        savePhoneNumbers(contact, req, "mobilenr", PhoneType.MOBILE);
        savePhoneNumbers(contact, req, "phonenr", PhoneType.PHONE);
    }

    private void savePhoneNumbers(Contact contact, HttpServletRequest req, String parameter, PhoneType type) {
        /**
         * Set phone numbers with request parameter (th field with map is rather difficult)
         * Check wether the map keys already exist or not, then change value or add new phone
         * if phone is empty and key already existed in map -> deletion. Hence the remove.
         * check phone validation here and throw error if not valid
         */
        if (!req.getParameter(parameter).equals("")) {
            if (contact.getPhones().get(type) != null) {
                contact.getPhones().get(type).setNumber(req.getParameter(parameter));
            } else {
                contact.addPhone(new Phone(req.getParameter(parameter), type));
            }
        } else {
            contact.getPhones().remove(type);
        }
    }

    private void extraValidation(Contact contact, BindingResult br, HttpServletRequest req) {
        if (contact.getEmail().equals("") && contact.getPhones().size() == 0) {
            br.addError(new FieldError("contact", "email", "Contact needs email or phone number"));
            br.addError(new FieldError("contact", "phones", "Contact needs phone number or email"));
        }
        if (!req.getParameter("mobilenr").matches("^[0]{1}[0-9]{7,9}$|$") || !req.getParameter("phonenr").matches("^[0]{1}[0-9]{7,9}$|$")  ) {
            br.addError(new FieldError("contact", "phones", "Please enter only valid phonenumbers"));
        }
    }
}

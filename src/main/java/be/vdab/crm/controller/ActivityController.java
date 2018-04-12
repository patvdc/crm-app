package be.vdab.crm.controller;

import be.vdab.crm.entity.Activity;
import be.vdab.crm.entity.Contact;
import be.vdab.crm.service.ActivityService;
import be.vdab.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@Controller
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private ContactService contactService;

    @GetMapping("/list")
    public String listAllActivities(Map<String , Object> map) {
        map.put("activityList",activityService.getAllActivities());

        return "activity-list";
    }

    @GetMapping("/details/{id}")
    public  String activityDetails(@PathVariable Integer id, Map<String, Object> map) {
        Activity ac = activityService.findActivityById(id);
        map.put("activity", ac);
//        map.put("contact", contactService.findContactById(activityService.getContactIdByActivityId(id)));
//        map.put("contact", contactService.findContactByActivity(ac));
        return "activity-details";
    }

    @GetMapping("/create/{id}")
    public String createActivityForm(@PathVariable Integer id , Map<String, Object> map) {
        map.put("activity", new Activity());
        map.put("contact", contactService.findContactById(id));
        return "activity-create";
    }

    @PostMapping("/create/{contactId}")
    public String createPostForm(Activity activity, BindingResult br) {
        if(br.hasErrors()) {
            return "activity-create";
        }
        activityService.save(activity);
        return "redirect:/contacts/details/{contactId}";
    }


}

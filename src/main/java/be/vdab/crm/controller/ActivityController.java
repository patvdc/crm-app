package be.vdab.crm.controller;

import be.vdab.crm.entity.Activity;
import be.vdab.crm.entity.Contact;
import be.vdab.crm.service.ActivityService;
import be.vdab.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
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
    public String createPostForm(Activity activity, BindingResult br ,Map<String, Object> map, HttpServletRequest req) {
        extraValidation(activity, br, req);
        if(br.hasErrors()) {
            map.put("contact", contactService.findContactById(activity.getContact().getId()));
            return "activity-create";
        }
        activityService.save(activity);
        return "redirect:/contacts/details/{contactId}";
    }

    private void extraValidation(Activity activity, BindingResult br, HttpServletRequest req) {
        if (activity.getSubject().equals("")) {
            br.addError(new FieldError("activity", "subject", "Subject is required"));
        }

        if (activity.getComment().equals("")) {
            br.addError(new FieldError("activity", "comment", "Comment is required"));
        }
//
//        if (activity.getDate().equals("")) {
//            br.addError(new FieldError("activity", "date", "Date is required"));
//        }
//
//        if (activity.getStartTime().equals("")) {
//            br.addError(new FieldError("activity", "startTime", "Star time is required"));
//        }
//        if (activity.getEndTime().equals("")) {
//            br.addError(new FieldError("activity", "endTime", "End time is required"));
//        }

    }


}

package be.vdab.crm.controller;

import be.vdab.crm.entity.Activity;
import be.vdab.crm.service.ActivityService;
import be.vdab.crm.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/activities")
public class AddressController {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private ContactService contactService;

    @RequestMapping("/list")
    public String listAllActivities(Map<String , Object> map) {
        map.put("activityList",activityService.getAllActivities());
        return "activity-list";
    }


}

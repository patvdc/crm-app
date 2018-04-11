package be.vdab.crm.service;

import be.vdab.crm.entity.Activity;
import be.vdab.crm.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActivityService {
    @Autowired
    private ActivityRepository activityReposotory;

    public List<Activity> getAllActivities() {return activityReposotory.findAll();}


}

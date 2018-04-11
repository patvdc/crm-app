package be.vdab.crm.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ActivityCategory category;
    private Date date;   //date of meeting,call/
    private Time startTime;    //when started
    private Time endTime;    //when stopped
    private String comment;     // saying that ..........
    private String subject;    //meeting @ customer x
    @Enumerated(EnumType.STRING)
    private ActivityStatus status;    //open  -> not yet done , closed -> done

    public Activity() {
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public ActivityCategory getCategory() { return category; }

    public void setCategory(ActivityCategory category) { this.category = category; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Time getStartTime() { return startTime; }

    public void setStartTime(Time startTime) { this.startTime = startTime; }

    public Time getEndTime() { return endTime; }

    public void setEndTime(Time endTime) { this.endTime = endTime; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public ActivityStatus getStatus() { return status; }

    public void setStatus(ActivityStatus status) { this.status = status; }
}

package be.vdab.crm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ActivityCategory category;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) // yyyy-MM-dd
    private LocalDate date;   //date of meeting,call/

    private LocalTime startTime;    //when started
    private LocalTime endTime;    //when stopped

    @Column(length=150)
    @Size(max = 150, message = "Maximum 150 characters")
    private String comment;     // saying that ..........
    @Column(length=50)
    @Size(max = 50, message = "Maximum 50 characters")
    private String subject;    //meeting @ customer x
    @Enumerated(EnumType.STRING)
    private ActivityStatus status;    //open  -> not yet done , closed -> done


    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    public Activity() {
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public ActivityCategory getCategory() { return category; }

    public void setCategory(ActivityCategory category) { this.category = category; }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public ActivityStatus getStatus() { return status; }

    public void setStatus(ActivityStatus status) { this.status = status; }

    public Contact getContact() { return contact; }

    public void setContact(Contact contact) { this.contact = contact; }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", category=" + category +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", comment='" + comment + '\'' +
                ", subject='" + subject + '\'' +
                ", status=" + status +
                ", contact=" + contact +
                '}';
    }
}

package be.vdab.crm.entity;

import be.vdab.crm.utility.ValidationForNotesInterface;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//contact can have multiple notes

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="value")
    @Size(max = 2000, message = "Maximum 2000 characters", groups = {ValidationForNotesInterface.class})
    @NotNull(message = "Empty notes are not allowed", groups = {ValidationForNotesInterface.class})
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

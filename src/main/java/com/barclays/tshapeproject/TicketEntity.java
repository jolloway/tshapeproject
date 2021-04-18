package com.barclays.tshapeproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private TshapeprojectApplication.Status status;
    private String description;
    private LocalDate last_edited;


    protected TicketEntity(){};
    public TicketEntity(String author, String title, TshapeprojectApplication.Status status, String description, LocalDate last_edited){
        this.author = author;
        this.title = title;
        this.status = status;
        this.description = description;
        this.last_edited = last_edited;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Enum getStatus() {
        return status;
    }
    public String getDescription() {
        return description;
    }
    public String getLast_edited(){
        return last_edited.toString();
    }

    public Long getId() {
        return id;
    }
}

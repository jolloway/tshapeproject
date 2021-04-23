package com.barclays.tshapeproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Tickets {
    private static final Logger LOGGER = LogManager.getLogger();

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TshapeprojectApplication.Status status;
    private String description;
    private LocalDate last_edited;


    protected Tickets(){}
    public Tickets(String author, String title, TshapeprojectApplication.Status status, String description, LocalDate last_edited){
        this.author = author;
        this.title = title;
        this.status = status;
        this.description = description;
        this.last_edited = last_edited;

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



    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title){this.title = title; }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(TshapeprojectApplication.Status status) {
        this.status = status;
    }
    public void setLast_edited(LocalDate localDate){
        this.last_edited = localDate;
    }}

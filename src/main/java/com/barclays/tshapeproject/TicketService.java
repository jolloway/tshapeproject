package com.barclays.tshapeproject;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {
    private TicketRepository repo;

    public TicketService(TicketRepository repo) {
        super();
        this.repo = repo;
    }


    public List<TicketEntity> getAllTickets(){  return null;}

    public List<TicketEntity>  getTicketById(@PathVariable("id") long id){  return null;}

    public List<TicketEntity>  getTicketByStatus(String status){
        switch(status){
            case "DEVELOPMENT":{}
            case "UAT_TESTING":{}
            case "CLOSED":{}
            case "PENDING":{}
            default: return null;//throw a web exception ;
        }
    }

    public Object addTicket(String author, String title, String status, String description){
        TshapeprojectApplication.Status statusEnum;
        switch(status){
            case "DEVELOPMENT":{ statusEnum = TshapeprojectApplication.Status.DEVELOPMENT;}
                break;
            case "UAT_TESTING":{statusEnum = TshapeprojectApplication.Status.UAT_TESTING;}
                break;
            case "CLOSED":{statusEnum = TshapeprojectApplication.Status.CLOSED;}
                break;
            case "PENDING":{statusEnum = TshapeprojectApplication.Status.PENDING;}
                break;
            default: return "invalid ticket status please enter: DEVELOPMENT , UAT_TESTING , CLOSED , PENDING";//throw a web exception ;
        }
        TicketEntity ticketEntity = new TicketEntity(author,title,statusEnum,description, LocalDate.now());
        return this.repo.save(ticketEntity);
    }

    public int  editTicket(long id, String field, String value){return 1;}
}

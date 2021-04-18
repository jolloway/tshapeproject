package com.barclays.tshapeproject;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketRestController {

    private TicketService service;

    public TicketRestController(TicketService service) {
        super();
        this.service = service;
    }
    @GetMapping("/getAllTickets")
    public List<TicketEntity>  getAllTickets(){
        return this.service.getAllTickets();
    }
    @GetMapping("/getTicketByID/{id}")
    public List<TicketEntity>  getTicketById(@PathVariable("id") long id){
        return this.service.getTicketById(id);
    }

    @GetMapping("/getTicketByStatus/{status}")
    public List<TicketEntity>  getTicketByStatus(@PathVariable("status") String status){
        return this.service.getTicketByStatus(status);
    }
    @PostMapping("/addTicket")
    public String  addTicket(String author, String title, String status, String description){
        return (String) this.service.addTicket(author, title, status, description);
    }
    @PutMapping("/editTicket/{id}/{field}/{value}")
    public int  editTicket(@PathVariable("id") long id, @PathVariable("field") String field, @PathVariable("value ")String value){
        return this.service.editTicket(id, field,value);
    }



}

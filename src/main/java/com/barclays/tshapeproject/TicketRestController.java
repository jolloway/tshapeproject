package com.barclays.tshapeproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TicketRestController {

    private final TicketService service;
    private static final Logger LOGGER = LogManager.getLogger();

    public TicketRestController(TicketService service) {
        super();
        this.service = service;
    }
    @GetMapping("/getAllTickets")
    public ResponseEntity<List<Tickets>> getAllTickets(){
        LOGGER.info("GetAllTickets request received");
        return new ResponseEntity<>(this.service.getAllTickets(),HttpStatus.OK);

    }
    @GetMapping("/getTicketByID/{id}")
    public ResponseEntity<Tickets>  getTicketById(@PathVariable("id") long id){

        LOGGER.info("GetTicketById request received with id: " + id );
        return new ResponseEntity<>(this.service.getTicketById(id),HttpStatus.ACCEPTED);
    }

    @GetMapping("/getTicketByStatus/{status}")
    public ResponseEntity<List<Tickets>>  getTicketByStatus(@PathVariable("status") String status){
        LOGGER.info("GetTicketByStatus request received with status: " + status );
        return new ResponseEntity<>(this.service.getTicketsByStatus(status),HttpStatus.OK);
    }
    @PostMapping("/addTicket")
    public ResponseEntity<String>  addTicket(@RequestBody String ticket){
        LOGGER.info("addTicket request received");
        this.service.addTicket(ticket);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Ticket created");
    }
    @PatchMapping("/editTicket/{id}/")
    public ResponseEntity<String>  editTicket(@PathVariable("id") long id, @PathParam("field") String field,
                              @PathParam("value")String value){
        LOGGER.info("editTicket request received with id: " + id + " field: " + field + " value: " + value);
        this.service.editTicket(id, field,value);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body("Ticket edited");
    }



}

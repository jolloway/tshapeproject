package com.barclays.tshapeproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;




@Service
public class TicketService {
    private TicketRepository repo;
    private static final Logger LOGGER = LogManager.getLogger();

    public TicketService(TicketRepository repo) {
        super();
        this.repo = repo;
    }


    public List<Tickets> getAllTickets(){
        return this.repo.findAll();
    }

    public Tickets getTicketById(long id){

        Optional result = this.repo.findById(id);
        if( result.isPresent()){
            return  (Tickets) result.get();
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid id - ticket does not exist");
        }
    }

    public List<Tickets>  getTicketsByStatus(String status){
        return this.repo.findTicketsByStatus(statusEnumFinder(status));
    }

    public Boolean addTicket(String ticket){
        BasicJsonParser parser = new BasicJsonParser();
        Map<String,Object> jsonMap;
        try{
             jsonMap = parser.parseMap(ticket) ;
        }catch(JsonParseException e){
            LOGGER.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"INVALID JSON REQUEST");
        }

        TshapeprojectApplication.Status statusEnum = statusEnumFinder(jsonMap.get("status").toString());

        Tickets tickets = new Tickets(jsonMap.get("author").toString(),jsonMap.get("title").toString(),statusEnum,jsonMap.get("description").toString(), LocalDate.now());
        Object created = this.repo.save(tickets);
        if(created != null ){
            return true;
        }else{
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "unknown error save failed");
        }

    }

    public Object editTicket(long id, String field, String value){
        try{
            Object ticket = this.repo.findById(id);

            if(ticket != null){
                Tickets unEditedTicket = (Tickets) ((Optional) ticket).get();
                Tickets editedTicket = unEditedTicket;
                switch(field.toLowerCase(Locale.ROOT)){
                    case "title": editedTicket.setTitle(value);
                    break;
                    case "status": editedTicket.setStatus(statusEnumFinder(value));
                    break;
                    case "description": editedTicket.setDescription(value);
                    break;
                    case  "author" : editedTicket.setAuthor(value);
                    break;
                }
                editedTicket.setLast_edited(LocalDate.now());

                return this.repo.save(editedTicket);

            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid id - ticket does not exist");
            }
        }catch(Exception e){
            LOGGER.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    public void deleteTicket(long id) {
        try{
            this.repo.deleteById(id);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid id - ticket does not exist" + e.getMessage());
        }
    }

    private TshapeprojectApplication.Status statusEnumFinder(String status){
        switch(status){
            case "DEVELOPMENT":{ return TshapeprojectApplication.Status.DEVELOPMENT;}
            case "UAT_TESTING":{return  TshapeprojectApplication.Status.UAT_TESTING;}
            case "CLOSED":{return TshapeprojectApplication.Status.CLOSED;}
            case "PENDING":{return  TshapeprojectApplication.Status.PENDING;}
            default: throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"invalid ticket status please enter: DEVELOPMENT , UAT_TESTING , CLOSED , PENDING") ;//throw a web exception ;
        }

    }
}

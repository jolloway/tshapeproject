import axios from 'axios';

const Ticket_API_BASE_URL = "http://localhost:8080"
class TicketService{
    getTickets(){
        return axios.get(Ticket_API_BASE_URL + "/getAllTickets");
    }

    getTicketsByID(id){
    return axios.get(Ticket_API_BASE_URL + "/getTicketByID/" + id);
    }

    ListSingularTicketID(id){
        return axios.get(Ticket_API_BASE_URL + "/ListSingularTicketID/" + id);
    }

    getTicketsByStatus(status){
        return axios.get(Ticket_API_BASE_URL + "/getTicketByStatus/" + status);
        }
    
    ListSingularTicketStatus(status){
        return axios.get(Ticket_API_BASE_URL + "/ListSingularTicketStatus/" + status);
    }
    editTicket(id,field,value){
        return axios.patch(Ticket_API_BASE_URL + "/editTicket/" + id + "/" + field + "/" + value)
    }

    createTicket(ticket){
        return axios.post(Ticket_API_BASE_URL + "/addTicket",ticket);
    }

    deleteTicket(id){
        return axios.delete(Ticket_API_BASE_URL + "/deleteTicket/" + id)
    }

}

export default new TicketService()
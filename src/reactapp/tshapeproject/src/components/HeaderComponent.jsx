import React, { Component } from 'react';
import { withRouter } from 'react-router-dom'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)
        this.allTickets = this.allTickets.bind(this);
        this.createTicket = this.createTicket.bind(this);
        this.editTicket = this.editTicket.bind(this);
        this.deleteTicket = this.deleteTicket.bind(this);
        this.statusTicket = this.statusTicket.bind(this);
        this.idTicket = this.idTicket.bind(this);

        this.state = {

        }
    }
    allTickets(){
        this.props.history.push("/getAllTickets")
    }

    createTicket(){
        this.props.history.push('/addTicket');
    }

    deleteTicket(){
        this.props.history.push('/deleteTicket');
    }

    editTicket(){
        this.props.history.push('/updateTicket');
    }

    statusTicket(){
        this.props.history.push('/statusTicket');
    }

    idTicket(){
        this.props.history.push('/getTicketById');
    }
    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className = "row">
                            <button className= "btn btn-primary" onClick={this.allTickets}>All Tickets</button>
                            <button className= "btn btn-primary" onClick={this.createTicket}>Create Ticket</button>
                            <button className= "btn btn-primary" onClick={this.editTicket}>Edit Ticket</button>
                            <button className= "btn btn-primary" onClick={this.deleteTicket}>Delete Ticket</button>
                            <button className= "btn btn-primary" onClick={this.statusTicket}>Tickets by Status</button>
                            <button className= "btn btn-primary" onClick={this.idTicket}>Tickets by ID</button>
                        </div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default withRouter(HeaderComponent);
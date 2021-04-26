import React, { Component } from 'react';
import TicketService from '../services/TicketService';
class DeleteTicketComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            id: ''
        }
        this.deleteID = this.deleteID.bind(this);
        this.changeIdHandler = this.changeIdHandler.bind(this);
    }

    changeIdHandler = (event) =>{
        this.setState({id: event.target.value})
    }



    deleteID = (e) => {
        e.preventDefault();
        console.log("form submitted")
        TicketService.deleteTicket(this.state.id).then(res => {
            this.props.history.push('/getAllTickets')
        });
    }
    
    render() {
        return (
                <div className = "container">
                    <div className = "row">
                        <form>
                            <div className="form-group">
                                <div className = "form-group">
                                   <label> id</label>
                                   <input placeholder= "id" name="id" className="form-control" value={this.state.id} onChange={this.changeIdHandler}/>
                                </div>
                             <button className="btn btn-success" onClick={this.deleteID}>Delete</button>
                            </div>
                         </form>
                    </div>
                </div>         
             
        )
    }
}

export default DeleteTicketComponent;
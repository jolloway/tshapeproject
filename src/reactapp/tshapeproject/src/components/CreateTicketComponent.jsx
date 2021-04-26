import React, { Component } from 'react';
import TicketService from '../services/TicketService';

class CreateTicketComponent extends Component {

    constructor(props){
        super(props)

        this.state = {
            author: '',
            description: '',
            title: '',
            status: ''
        }

        this.changeAuthorHandler = this.changeAuthorHandler.bind(this);
        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeDescriptionHandler = this.changeDescriptionHandler.bind(this);
        this.changeStatusHandler = this.changeStatusHandler.bind(this);
    }

    changeAuthorHandler = (event) =>{
        this.setState({author: event.target.value})
    }
    changeTitleHandler = (event) =>{
        this.setState({title: event.target.value})
    }
    changeDescriptionHandler = (event) =>{
        this.setState({description: event.target.value})
    }
    changeStatusHandler = (event) =>{
        this.setState({status: event.target.value})
    }

    saveTicket = (e) => {
        e.preventDefault();
        let ticket = {author: this.state.author,title: this.state.title,description: this.state.description, status: this.state.status};
        console.log('ticket => ' + JSON.stringify(ticket));

        TicketService.createTicket(ticket).then(res => {
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
                                <label> author</label>
                                <input placeholder= "author" name="author" className="form-control" value={this.state.author} onChange={this.changeAuthorHandler}/>
                            </div>
                            <div className = "form-group">
                                <label> title</label>
                                <input placeholder= "title" name="title" className="form-control" value={this.state.title} onChange={this.changeTitleHandler}/>
                            </div>
                            <div className = "form-group">
                                <label> description</label>
                                <input placeholder= "description" name="description" className="form-control" value={this.state.description} onChange={this.changeDescriptionHandler}/>
                            </div>
                            <div className = "form-group">
                                <label for= "sel1"> status</label>
                                <select type="text" placeholder="status" id= "sel1" name="status"   className="form-control" value={this.state.status} onChange={this.changeStatusHandler}>
                                    <option>Select</option>
                                    <option value="UAT_TESTING" >UAT TESTING</option>
                                    <option value="CLOSED" >CLOSED</option>
                                    <option value="PENDING" >PENDING</option>
                                    <option value="DEVELOPMENT" >DEVELOPMENT</option>
                                </select>
                            </div>
                            <button className="btn btn-success" onClick={this.saveTicket}>add ticket</button>
                        </div>
                    </form>
                </div>
                
            </div>
        );
    }
}

export default CreateTicketComponent;
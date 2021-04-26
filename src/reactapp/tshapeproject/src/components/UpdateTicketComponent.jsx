import React, { Component } from 'react';
import TicketService from '../services/TicketService';

class UpdateTicketComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            id: '',
            field: '',
            value: ''
        }

        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeFieldHandler = this.changeFieldHandler.bind(this);
        this.changeValueHandler = this.changeValueHandler.bind(this);
    }

    changeIdHandler = (event) =>{
        this.setState({id: event.target.value})
    }
    changeFieldHandler = (event) =>{
        this.setState({field: event.target.value})
    }
    changeValueHandler = (event) =>{
        this.setState({value: event.target.value})
    }


    saveTicket = (e) => {
        e.preventDefault();
        TicketService.editTicket(this.state.id,this.state.field,this.state.value).then(res => {
            var URI = "/ListSingularTicketID/" + this.state.id;
            this.props.history.push(URI);
        });
    }
    render() {
        return (
            <div className = "container">
                <div className = "row">
                   <form>
                       <div className="form-group">
                           <p>if editing status: please use DEVELOPMENT, UAT_TESTING, CLOSED or PENDING</p>
                            <div className = "form-group">
                                <label> id</label>
                                <input placeholder= "id" name="id" className="form-control" value={this.state.id} onChange={this.changeIdHandler}/>
                            </div>
                            <div className = "form-group">
                                <label> field</label>
                                <input placeholder= "field" name="field" className="form-control" value={this.state.field} onChange={this.changeFieldHandler}/>
                            </div>
                            <div className = "form-group">
                                <label> value</label>
                                <input placeholder= "value" name="value" className="form-control" value={this.state.value} onChange={this.changeValueHandler}/>
                            </div>
                            <button className="btn btn-success" onClick={this.saveTicket}>edit ticket</button>
                        </div>
                    </form>
                </div>
                
            </div>
        );
    }
}

export default UpdateTicketComponent;
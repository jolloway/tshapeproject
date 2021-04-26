import React, { Component } from 'react';

class TicketByIdComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            tickets: '',
            id: ''
        }
        this.submitID = this.submitID.bind(this);
        this.changeIdHandler = this.changeIdHandler.bind(this);
    }

    changeIdHandler = (event) =>{
        this.setState({id: event.target.value})
    }



    submitID(){
       this.props.history.push(`/ListSingularTicketID/${this.state.id}`);
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
                             <button className="btn btn-success" onClick={this.submitID}>submit</button>
                            </div>
                         </form>
                    </div>
                </div>         
             
        )
    }
            
}

export default TicketByIdComponent;
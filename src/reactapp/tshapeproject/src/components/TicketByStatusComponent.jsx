import React, { Component } from 'react';

class TicketByStatusComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            status: '',
           
        }
        this.submitStatus = this.submitStatus.bind(this);
        this.changeStatusHandler = this.changeStatusHandler.bind(this);
    }

    changeStatusHandler = (event) =>{
        this.setState({status: event.target.value})
    }



    submitStatus(){
       this.props.history.push(`/ListSingularTicketStatus/${this.state.status}`);
    }
    
    render() {
        return (
                <div className = "container">
                    <div className = "row">
                        <form>
                            <div className="form-group">
                                <div className = "form-group">
                                <label for= "sel1"> status</label>
                                <select type="text" placeholder="status" id= "sel1" name="status"   className="form-control" value={this.state.status} onChange={this.changeStatusHandler}>
                                    <option>Select </option>
                                    <option value="UAT_TESTING" >UAT TESTING</option>
                                    <option value="CLOSED" >CLOSED</option>
                                    <option value="PENDING" >PENDING</option>
                                    <option value="DEVELOPMENT" >DEVELOPMENT</option>
                                </select>
                                </div>
                             <button className="btn btn-success" onClick={this.submitStatus}>submit</button>
                            </div>
                         </form>
                    </div>
                </div>         
             
        )
    }
            
}

export default TicketByStatusComponent;